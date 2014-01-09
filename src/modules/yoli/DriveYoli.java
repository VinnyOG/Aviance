package modules.yoli;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author meydany
 */
public class DriveYoli extends GyroYoli {
    
      //Creating jaguars 
      Jaguar frontright = new Jaguar(1);
      Jaguar frontleft = new Jaguar(2);
      Jaguar backright = new Jaguar(3);
      Jaguar backleft = new Jaguar(4);
      
      //Creating joysticks
      public Joystick rightjoy = new Joystick(1);
      public Joystick leftjoy = new Joystick(2);
               
      protected void iteration() {
      
        double rightval = rightjoy.getY();
        double leftval = leftjoy.getY();
        
        boolean tLeft = rightjoy.getRawButton(3);
        boolean tRight = rightjoy.getRawButton(3);

        //setting speed
        frontright.set(-1 * rightval);
        backright.set(-1 * rightval);

        frontleft.set(leftval);
        backleft.set(leftval);
        
        if(tLeft) {
            double less = angle + 45;
            
            while (angle < less){
                leftval = -1;
                rightval = 1;   
                        
                backleft.set(leftval);
                frontleft.set(leftval);
                backright.set(-1 * rightval);
                frontright.set(-1 * rightval);   
             }
        }

        if(tRight) {
            double less1 = angle + 45;
            
            while (angle < less1){
                leftval = 1;
                rightval = -1;
                        
                backleft.set(leftval);
                frontleft.set(leftval);
                backright.set(-1 * rightval);
                frontright.set(-1 * rightval);
             }
         }
       
      }
      
      protected void reset() {
          System.out.println("Shutting down robot");
      }
}

           
