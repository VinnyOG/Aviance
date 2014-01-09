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
 * @author zitellim
 */
public class SolenoidMarc extends AvianceThread {
    Joystick Right = new Joystick(1);
    Joystick Left = new Joystick(2);
    
    DoubleSolenoid piston = new DoubleSolenoid(1,2);
    
    protected void iteration() {
        boolean pistonBut = Right.getRawButton(1);
       
                
        
        if(pistonBut){
            
                piston.set(DoubleSolenoid.Value.kReverse);
            
        } 
        else{
          
                piston.set(DoubleSolenoid.Value.kForward);
                
                
            
            
        }
            
    }
}
