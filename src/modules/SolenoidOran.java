/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
/**
 *
 * @author luzono
 */
public class SolenoidOran {
    
    public Joystick left = new Joystick (1);
    DoubleSolenoid sol = new DoubleSolenoid (1,2);
    boolean pressed = left.getRawButton(1);
        
    public void iteration(){
        
        if (pressed == true){
            sol.set(DoubleSolenoid.Value.kForward);
            Timer.delay(2);
            sol.set(DoubleSolenoid.Value.kReverse);
                    }
    }    
}
