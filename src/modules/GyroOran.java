/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;

import edu.wpi.first.wpilibj.Gyro;
import mainframe.AvianceThread;

/**
 *
 * @author luzono
 */
public class GyroOran extends AvianceThread{
    Gyro direction = new Gyro(1);
    double angle;
    
    public void startup(){
        direction.reset();
    }
    protected void iteration(){
        angle = direction.getAngle();
        
    }
    
}
