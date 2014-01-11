/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.SecondRobot;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Yoli
 */
public class ClawWheel {
    
    Jaguar wheel = new Jaguar(5);
    Joystick rightjoy = new Joystick(1);
    
    boolean pressed = rightjoy.getRawButton(4);
    
    protected void iteration() {
        
        while(pressed) {
            wheel.set(1); //Turns wheel to receive ball
        }
        
    }
       
}
