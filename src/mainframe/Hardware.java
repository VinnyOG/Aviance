/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author pawel
 */
public class Hardware {
    // hardware will be accessed depending on type
    
    // PWM ports for each element
    public static final Talon talonFL = new Talon(1);
    public static final Talon talonFR = new Talon(2);
    public static final Talon talonBL = new Talon(3);
    public static final Talon talonBR = new Talon(4);
    public static final Talon talonShooter = new Talon(5);
    
    public static final Relay relay_arm = new Relay(1);
    public static final Relay relay_winch = new Relay(2);
    
    
    //Individualized hardware
    public static Joystick joystick1 = new Joystick(1); // joysticks are NOT FINAL; this allows the JoystickSwapper to swap them
    public static Joystick joystick2 = new Joystick(2); //we can make them non-final and create a module that listens for a button to swap them and then swaps them
    
    public static final Encoder encoder_front_left = new Encoder(1,2);  //this is a more concise way of doing things even though it's slightly inconsistent
    public static final Encoder encoder_front_right = new Encoder(3,4);
    public static final Encoder encoder_back_left = new Encoder(5,6);
    public static final Encoder encoder_back_right = new Encoder(7,8);
    
    // we need to start the ecoders literally
   /***
    * This is responsible for initializing hardware that isn't already when the class is loaded into the VM
    */
    static{
        //this is going to be slighlty more involved..
        //actually, its not going to be difficult at all..
        System.out.println("Initializing Hardware...");
        
        
        encoder_front_left.start();
        encoder_front_right.start();
        encoder_back_left.start();    //or maybe we should do this in its own module? that works
        encoder_back_right.start();
     
    }
}