package modules.yoli;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author meydany
 */
public class SolenoidYoli {
      
    public Joystick rightjoy = new Joystick(1);
    DoubleSolenoid piston = new DoubleSolenoid(1, 2);
    
    protected void iteration() {
        
        boolean pressed1 = rightjoy.getRawButton(3);

        DoubleSolenoid.Value opened = piston.get();
        
        if(pressed1 && opened == DoubleSolenoid.Value.kReverse) {
            piston.set(DoubleSolenoid.Value.kForward);
        } else if(pressed1 && opened == DoubleSolenoid.Value.kForward) {
            piston.set(DoubleSolenoid.Value.kReverse);
        }
        
    }     
}
