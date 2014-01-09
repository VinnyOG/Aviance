/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author cecchil
 */
public class LucasSolenoid {
  Joystick buttonJoy = new Joystick(1);
  DoubleSolenoid piston1 = new DoubleSolenoid(1,2);  
  boolean isPushed;
  
    public void iteration(){
    isPushed = buttonJoy.getRawButton(1);
        if(isPushed){
    while(true){
         piston1.set(DoubleSolenoid.Value.kForward);
         isPushed = buttonJoy.getRawButton(1);
         if(isPushed){
             break;
         }
        }
   piston1.set(DoubleSolenoid.Value.kOff);
        }
}

    public void reset() {
    System.out.println("resetting now");
    }
    public void startup(){
    System.out.println("starting up");
    }

}