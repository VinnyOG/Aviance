
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
        
        Jaguar bl = new Jaguar(1);
        Jaguar br = new Jaguar(2);
        Jaguar fl = new Jaguar(3);
        Jaguar fr = new Jaguar(4);
        
        public void startup(){
        
        }
        
       
        protected void iteration(){
                double leftvalue;
                double rightvalue;
                    
                leftvalue = left.getY();
                rightvalue = right.getY();

                bl.set(leftvalue);
                fl.set(leftvalue);
                br.set(-1 * rightvalue);
                fr.set(-1 * rightvalue);
       }
        
        public void reset(){
        
        }
} 


