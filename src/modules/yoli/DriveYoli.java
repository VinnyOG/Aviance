package modules.yoli;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author meydany
 */
public class DriveYoli {
    
      //Creating jaguars 
      Jaguar frontright = new Jaguar(1);
      Jaguar frontleft = new Jaguar(2);
      Jaguar backright = new Jaguar(3);
      Jaguar backleft = new Jaguar(4);
      
      //Creating joysticks
      public Joystick rightjoy = new Joystick(1);
      public Joystick leftjoy = new Joystick(2);
            
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
       
      }
      
      protected void reset() {
          System.out.println("Shutting down robot");
      }
}

           
