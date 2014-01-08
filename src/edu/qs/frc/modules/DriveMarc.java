/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.qs.frc.modules;

import edu.qs.frc.threading.AvianceThread;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author zitellim
 */
public class DriveMarc extends AvianceThread {
    
    Joystick rightJoy = new Joystick(1); 
    Joystick leftJoy = new Joystick(2);
    
    Talon TR = new Talon(1);
    Talon TL = new Talon(2);
    Talon BR = new Talon(3);
    Talon BL = new Talon(4);
    
    
    double leftTank;
    double rightTank;
    
    protected void iteration(){
     rightTank = rightJoy.getY();
     leftTank = leftJoy.getY();
     TR.set(rightTank);
     TL.set(leftTank);
     BR.set(rightTank);
     BL.set(leftTank);
     
        
    } 
    
}
