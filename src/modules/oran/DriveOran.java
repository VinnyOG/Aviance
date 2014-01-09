
package modules.oran;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import mainframe.AvianceThread;

/**
 *
 * @author luzono
 */
public class DriveOran extends AvianceThread {

       Joystick left = new Joystick(1);
       Joystick right = new Joystick(2);
        
        Jaguar l = new Jaguar(1);
        Jaguar r = new Jaguar(2);
        
        public void startup(){
        
        }
        
       
        protected void iteration(){
                double leftvalue;
                double rightvalue;
                    
                leftvalue = left.getY();
                rightvalue = right.getY();

                l.set(leftvalue);
                r.set(-1 * rightvalue);
       }
        
        public void reset(){
        
        }
} 


