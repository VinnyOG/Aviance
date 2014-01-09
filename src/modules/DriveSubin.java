/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author samuels1
 */
public class DriveSubin {
    Talon rightFront = new Talon(1);
    Talon leftFront = new Talon(2);
    Talon rightBack = new Talon(3);
    Talon leftBack = new Talon(4);
    
    Joystick leftJS= new Joystick(1);
    Joystick rightJS = new Joystick(2);
    
    protected void startup(){}
    protected void iteration(){
        
        double rValue = rightJS.getY();
        double lValue = leftJS.getY();
        
        boolean rightJSPress = rightJS.getRawButton(2);
        boolean leftJSPress = leftJS.getRawButton(3);
        
        if(leftJSPress){
        leftFront.set(lValue);
        leftBack.set(lValue);
        }
        else if(rightJSPress){
        rightFront.set(-1*rValue);
        rightBack.set(-1*rValue);
        }
    }
    protected void reset(){}
}
