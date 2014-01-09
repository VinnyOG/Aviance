/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import mainframe.AvianceThread;
/**
 *
 * @author samuels1
 */
public class SolenoidSubin extends AvianceThread{
    public DoubleSolenoid solenoid = new DoubleSolenoid(1,2);
      
    public Joystick leftJS = new Joystick(1);
  
    protected void startup(){
        System.out.println("Starting Up Solenoid");
    }
    protected void iteration(){
    boolean press = leftJS.getRawButton(1);
    while(true){
   if(press){
       solenoid.set(DoubleSolenoid.Value.kForward);
        }else if(!(press)){
       solenoid.set(DoubleSolenoid.Value.kReverse);
        }
    break;
    }
   
   }
    protected void reset(){
        System.out.println("Shutting Down Solenoid");
    }
}
