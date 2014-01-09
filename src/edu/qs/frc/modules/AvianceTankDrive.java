/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.qs.frc.modules;

import edu.qs.frc.hardware.Hardware;
import edu.qs.frc.threading.AvianceThread;
import edu.qs.frc.threading.AvianceThreadManager;
import edu.wpi.first.wpilibj.Talon;


/**
 *
 * @author admin
 */
public class AvianceTankDrive extends AvianceThread{
    
    /**
     * Here declare all the Hardware and variables you need.
     * DO NOT make 'new' hardware; use the Hardware class
     */
    Talon back_left = Hardware.talonBL;
    Talon back_right = Hardware.talonBR;
    Talon front_left = Hardware.talonFL;
    Talon front_right = Hardware.talonFR;
    
    
    /**
     * This is the class constructor, it has the same name as the class you declared.
     * This is where you add the module to the thread group you wish to be a part of,
     * When you type AvianceRobot. with the period NetBeans will give you a list of strings for group names
     * 
     */
    public AvianceTankDrive(){
        AvianceThreadManager.getInstance().addThread(AvianceRobot.teleopThreads, this);
    }
    
    /**
     * This is equivalent to any while loop you would ordinarily create, put update logic in here
     * By default the iteration() method is called approximately 33 times per second
     */
    protected void iteration(){
        
        double left = Hardware.joystick2.getY();
        double right = Hardware.joystick1.getY();
        
        back_left.set(left);
        front_left.set(left);
        back_right.set( -1 * right);
        front_right.set( -1 * right);
    }
    
    /**
     * When the module gets interrupted this is the method that is called before the module turns off
     * i.e. when the thread group stops this is invoked
     */
    protected void reset(){
        System.out.println("Drive Interrupt");
    }
    
    /**
     * This method is called right before iteration() and runs only once
     */
    protected void startup(){
        System.out.println("Starting Drive");
    }
}
