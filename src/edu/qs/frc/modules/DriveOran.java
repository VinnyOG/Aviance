
package edu.qs.frc.modules;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid;
/**
 *
 * @author luzono
 */
public class DriveOran {

       Joystick left = new Joystick(1);
       Joystick right = new Joystick(2);
        
        Talon fl = new Talon(1);
        Talon bl = new Talon(2);
        Talon fr = new Talon(3);
        Talon br = new Talon(4);
        DoubleSolenoid sol = new DoubleSolenoid (1,2);
        
         
        public void startup(){
        
        }
        
        
        protected void iteration(){
                double leftvalue;
                double rightvalue;
                //sol.set();
            
                leftvalue = left.getY();
                rightvalue = right.getY();

                fl.set(leftvalue);
                bl.set(leftvalue);
                fr.set(-1 * rightvalue);
                br.set(-1 * rightvalue);
       }
        
        public void reset(){
        
        }
} 


