/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.qs.frc.modules;

import edu.qs.frc.hardware.Hardware;
import edu.qs.frc.threading.AvianceThread;
import edu.qs.frc.threading.AvianceThreadInterruptedException;
import edu.qs.frc.threading.AvianceThreadManager;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.ADXL345_I2C.AllAxes;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Watchdog;

/**
 *
 * @author Darvin
 *
 * AvianceRobot class adds this in manually, this class is NOT responsible for
 * managing its threadgroup membership
 */
public class SciBorgsTrack extends AvianceThread {

    private int x = 0;
    private int y = 0;
    private static ADXL345_I2C ac = Hardware.accelerometer;
    private Watchdog wd = Watchdog.getInstance();

    public SciBorgsTrack() {
        AvianceThreadManager.getInstance().addThread(AvianceRobot.teleopThreads, this);
    }

    protected void iteration() {
        double pi = Math.PI;
        double velX = 0;
        double velY = 0;
        wd.feed();
        while (true) {

            double cAngle = (Hardware.gyro.getAngle()) * pi / 180;

            if (anglecheck(cAngle) == true) {

                double accX = ac.getAcceleration(ADXL345_I2C.Axes.kX) * 9.80665;
                double accY = ac.getAcceleration(ADXL345_I2C.Axes.kY) * 9.80665;

                //change in time
                double t = wd.getTimer();
                wd.feed();

                //change in velocity and add to overall velocity
                double dvelX = accX * t;
                velX += dvelX;
                double dvelY = accY * t;
                velY += dvelY;

                //find acc using angle and calculate change in position
                double accXa = accX * Math.cos(cAngle) + accY * Math.cos((pi / 2) + cAngle);
                double dposX = (velX * t) + (0.5 * t * t) * accXa;
                double accYa = accX * Math.sin(cAngle) + accY * Math.sin((pi / 2) + cAngle);
                double dposY = (velY * t) + (0.5 * t * t) * accYa;

                //add
                x += dposX;
                y += dposY;
            }
        }
    }

    public static boolean anglecheck(double a) {
        return (a<0)?false:true;
    }

    protected void reset() {
        System.out.println("Resetting Tracking...");
        x = y = 0;
        wd.setEnabled(false);
        wd.setEnabled(true);
    }

    protected void startup() {
        System.out.println("Starting Tracking");
        wd.setEnabled(true);
    }

}
