package mainframe;

/*
 * StartApplication.java
 *
 */
import edu.qs.frc.modules.*;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

/**
 * The startApp method of this class is called by the VM to start the
 * application.
 * 
 * The entry point is responsible for starting and monitoring all robot subsystems
 */
public class EntryPoint extends MIDlet {

    protected void startApp() throws MIDletStateChangeException {
        
        //start client connection to rhaspberry pi
        
        /*
         * This line of code alone is enough to start the bot, the instancization
         * code takes care of creating the needed thred groups and starting the
         * one that contains the robot thread, at this point the robot is
         * self maintained and no outside access may stop it (except for a call
         * to interrupt(), this stops the robot)
         * 
         * ALL MODULES ARE RESPONSIBLE FOR ADDING THEMSELVES TO THE THREADGROUP THEY BELONG TO
         */
        new AvianceRobot();
        new AvianceTankDrive();
   //for now that'll stay as an easter egg; an hour for now, if it's a problem we can always change it
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
        //close connections
    }
    
}
