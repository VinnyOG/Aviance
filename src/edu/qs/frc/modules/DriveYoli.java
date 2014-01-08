package edu.qs.frc.modules;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid;



/**
 *
 * @author meydany
 */
public class DriveYoli {
    
      //Creating talons 
      Talon frontright = new Talon(1);
      Talon frontleft = new Talon(2);
      Talon backright = new Talon(3);
      Talon backleft = new Talon(4);
      
      //Creating joysticks
      Joystick rightjoy = new Joystick(1);
      Joystick leftjoy = new Joystick(2);
      
      DoubleSolenoid piston = new DoubleSolenoid(1, 2);
      
      
      protected void startup() {
          System.out.println("Starting up robot");
      }
        
      protected void iteration() {
      
        double rightval = rightjoy.getY();
        double leftval = leftjoy.getY();

        //setting speed
        frontright.set(-1 * rightval);
        frontleft.set(-1 * rightval);

        backright.set(leftval);
        backleft.set(leftval);
        
        DoubleSolenoid.Value pistonval = piston.get();
        
        piston.set(pistonval);
      }
      
      protected void reset() {
          System.out.println("Shutting down robot");
      }
}

           
