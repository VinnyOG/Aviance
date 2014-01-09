/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.qs.frc.modules;

import com.sun.squawk.Isolate;
import edu.qs.frc.threading.AvianceThread;
import edu.qs.frc.threading.AvianceThreadInterruptedException;
import edu.qs.frc.threading.AvianceThreadManager;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.communication.FRCControl;
import edu.wpi.first.wpilibj.communication.UsageReporting;

/**
 *
 * @author pawel
 */
public final class AvianceRobot extends AvianceThread {

    private final AvianceThreadManager threadManager = AvianceThreadManager.getInstance();
    public static DriverStation driverStation = DriverStation.getInstance();
    private final Watchdog watchdog = Watchdog.getInstance();
    private final AutonomousRoutinePoller poller;

    public static final String systemThreadGroup = "roboxsysthreads";
    public static final String teleopThreads = "teleoperatedthreads";
    public static final String continiousThreads = "continiousthreads";
    public static final String[] autonomousRoutines = new String[5];

    private int autonomousRoutine = 1;
    private boolean autonomous;
    private boolean teleoperated;
    private boolean disabled;

    public AvianceRobot() {

        //Taking care of buissness
        watchdog.setEnabled(false);
        FRCControl.observeUserProgramStarting();
        UsageReporting.report(UsageReporting.kResourceType_Language, UsageReporting.kLanguage_Java);

        //Initial thread groups made and started
        threadManager.addThread(systemThreadGroup, this);
        threadManager.addThread(systemThreadGroup, poller = new AutonomousRoutinePoller()); //the robot adds this in manually, and not in the entry point
        threadManager.startThreads(systemThreadGroup);

        for (int i = 0; i < autonomousRoutines.length; i++) {
            threadManager.createGroup(autonomousRoutines[i] = "autonomousRoutine" + i);
        }
    }

    protected void iteration() throws AvianceThreadInterruptedException {

        autonomousRoutine = poller.getRoutine();
        if (autonomousRoutine > autonomousRoutines.length || autonomousRoutine < 1) {
            autonomousRoutine = 1;
        }
        disabled = driverStation.isDisabled();
        autonomous = driverStation.isAutonomous();
        teleoperated = driverStation.isOperatorControl();

        if (disabled) {
            while (driverStation.isDisabled())
                AvianceThreadHousekeeping(sleepTime);
        } 
        
        else if (autonomous) {
            threadManager.startThreads(autonomousRoutines[autonomousRoutine]);

            while (driverStation.isEnabled())
                AvianceThreadHousekeeping(sleepTime);
            threadManager.interruptThreads(autonomousRoutines[autonomousRoutine]);
        } 
        
        else if (teleoperated) {
            threadManager.startThreads(teleopThreads);

            while (driverStation.isEnabled())
                AvianceThreadHousekeeping(sleepTime);
            threadManager.interruptThreads(teleopThreads);
        }
    }
    
    protected void reset(){
        System.err.println("*AvianceRobot caught Exception*");
    }
}
