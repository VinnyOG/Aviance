/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import mainframe.AvianceThread;

/**
 *
 * @author cecchil
 */

/**
 *
 * @author cecchil
 */
public class DriveLucas extends AvianceThread {
    
//Hardware
Joystick rightJoy = new Joystick(1);
Joystick leftJoy = new Joystick(2);

Talon leftTop = new Talon(1);
Talon leftBot = new Talon(2);
Talon rightTop = new Talon(3);
Talon rightBot = new Talon(4);

DoubleSolenoid piston1 = new DoubleSolenoid(1,2);

//Variables
double leftTank;
 double rightTank;
   boolean button1;
   boolean button2;
 //Driver Controlled
   
   protected void startup(){
   System.out.println("starting up");
   }
   
   
   protected void iteration(){
   button1 = rightJoy.getRawButton(1);
   button2 = rightJoy.getRawButton(2);
        if(button1 == true){
   while(true){
       button1 = rightJoy.getRawButton(1);
   button2 = rightJoy.getRawButton(2);
    rightTank = rightJoy.getY();
    leftTank = leftJoy.getY();
    leftTop.set(leftTank);
    leftBot.set(leftTank);
    rightTop.set(rightTank);
    rightBot.set(rightTank);
    button1 = rightJoy.getRawButton(1);
   
    if(button2 == true){
    piston1.set(DoubleSolenoid.Value.kForward);
   } 
   
   if(button1 == false){
    break;
    }
   }
   }
   if(button2 == true){
    piston1.set(DoubleSolenoid.Value.kForward);
   } 
    }

protected void reset(){
System.out.println("shutting down");
}

}
