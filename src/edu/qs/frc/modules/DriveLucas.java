/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.qs.frc.modules;

import edu.qs.frc.threading.AvianceThread;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid;

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
   
 //Driver Controlled
    protected void iteration(){
   piston1.set(DoubleSolenoid.Value.kForward);
    rightTank = rightJoy.getY();
    leftTank = leftJoy.getY();
    leftTop.set(leftTank);
    leftBot.set(leftTank);
    rightTop.set(rightTank);
    rightBot.set(rightTank);
    
    
    
    }
}
