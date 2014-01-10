package modules.SecondRobot;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author meydany
 */
public class Drive extends GyroRobot {
    
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

        //setting speed
        frontright.set(-1 * rightval);
        backright.set(-1 * rightval);

        frontleft.set(leftval);
        backleft.set(leftval);
        
         //For Gyro
        boolean lButton = rightjoy.getRawButton(1);
        boolean rButton = rightjoy.getRawButton(2);
        
        //Does Gyro increase angle no matter what direction you're going in?
        if(lButton) {
            double less = angle + 315;
            
            while (angle < less){
                leftval = -1;
                rightval = 1;   
                        
                backleft.set(leftval);
                frontleft.set(leftval);
                backright.set(-1 * rightval);
                frontright.set(-1 * rightval);   
             }
            Timer.delay(1);
            
            if(lButton) {
                leftval = -1;
                rightval = 1;   
                        
                backleft.set(leftval);
                frontleft.set(leftval);
                backright.set(-1 * rightval);
                frontright.set(-1 * rightval); 
            }
        }

        if(rButton) {
            double less1 = angle + 45;
            
            while (angle < less1){
                leftval = 1;
                rightval = -1;
                        
                backleft.set(leftval);
                frontleft.set(leftval);
                backright.set(-1 * rightval);
                frontright.set(-1 * rightval);
             }
            Timer.delay(1);
            
            if(rButton) {
                leftval = 1;
                rightval = -1;
                        
                backleft.set(leftval);
                frontleft.set(leftval);
                backright.set(-1 * rightval);
                frontright.set(-1 * rightval);
            }
         }
       
      }
      
      protected void turnon() {
          System.out.println("Turning on drive");
      }
      
      protected void turnoff() {
          System.out.println("Shutting down drive");
      }
}

           
