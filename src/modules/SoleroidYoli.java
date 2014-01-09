package modules;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;


/**
 *
 * @author meydany
 */
public class SoleroidYoli {
      
    public Joystick rightjoy = new Joystick(1);
    DoubleSolenoid piston = new DoubleSolenoid(1, 2);
    
    boolean pressed1 = rightjoy.getRawButton(1);
    boolean pressed2 = rightjoy.getRawButton(2);
    
    protected void iteration() {
        
        if(pressed1) {
            piston.set(DoubleSolenoid.Value.kForward);
        }
        
        if(pressed2) {
            piston.set(DoubleSolenoid.Value.kReverse);
        }
        
    }
}
