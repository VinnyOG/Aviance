/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import mainframe.AvianceThread;

/**
 *
 * @author spinerc
 */
public class SolenoidCory extends AvianceThread {
    
    //creating joystick
    Joystick jRight = new Joystick(1);
    
    DoubleSolenoid piston = new DoubleSolenoid(1,2);

    protected void iteration() {
        //seting output boolean to if button is pressed
        boolean bPress = jRight.getRawButton(1);
                
        if(bPress) {            
            piston.set(DoubleSolenoid.Value.kForward);
        }        
        else {
            piston.set(DoubleSolenoid.Value.kReverse);          
        }         
    }
}
