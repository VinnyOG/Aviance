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
 * @author spinerc
 */
public class DriveCory {
    
    //Declaring Motor controlers
    Talon fRight = new Talon(1);
    Talon fLeft = new Talon(2);
    Talon bRight = new Talon(3);
    Talon bLeft = new Talon(4);
    
    //Declaring Joysticks
    Joystick jRight = new Joystick(1);
    Joystick jLeft = new Joystick(2);
    
    protected void startup() {
        System.out.println("Starting up...");
    }
    
    protected void iteration() {
     
        //getting joystick values
        double rightval = jRight.getY();
        double leftval = jLeft.getY();
            
        //setting speed
        fRight.set(-1 * rightval);
        fLeft.set(leftval);
   }
    protected void reset() {
         System.out.println("Shutting down...");
   }
}
