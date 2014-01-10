package modules.SecondRobot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author meydany
 */
public class Solenoid{
      
    public Joystick rightjoy = new Joystick(1);
    DoubleSolenoid piston = new DoubleSolenoid(1, 2);
    
    protected void iteration() {
        
        boolean pressed = rightjoy.getRawButton(3);
        
        //Made a lot simpler 
        while(pressed) {
            piston.set(DoubleSolenoid.Value.kForward);
        }
        
    }  
    
    protected void turnOn() {
        System.out.println("Solenoids on");
    }
    
    protected void turnOff() {
        System.out.println("Solenoids off");
    }
}
