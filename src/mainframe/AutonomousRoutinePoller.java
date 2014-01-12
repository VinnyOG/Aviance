/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Darvin

 AvianceRobot class adds this in manually, this class is NOT responsible for
 managing its threadgroup membership
 */
public class AutonomousRoutinePoller extends AvianceThread {

    private final Object intLock = new Object();
    private int routine = 1;

    int value = 1;
    final int[] buttons = {1, 2, 3, 4, 5}; //these are the raw button codes for each routine

    {
        SmartDashboard.putNumber("Autonomous Routine", value);
    }

    public int getRoutine() {
        synchronized (intLock) {
            return routine;
        }
    }

    //just look at how much nicer and more concise this is
    protected void iteration() {
        for (int i = 0; i < buttons.length; i++) {
            if (Hardware.joystick1.getRawButton(buttons[i])) //if the button in a particular slot is pressed
            {
                value = i + 1;  //then the routine is set to that slot + 1 (since routines count from 1 not 0) ok
            }
        }

        synchronized (intLock) {

            if (value != routine) {
                System.out.println("Autonomous Routine changed: " + value);
            }
            SmartDashboard.putNumber("Autonomous Routine", value);
            routine = value;
        }
    }

}
