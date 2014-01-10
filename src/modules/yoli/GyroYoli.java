/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.yoli;

import edu.wpi.first.wpilibj.Gyro;
import mainframe.AvianceThread;

/**
 *
 * @author meydany
 */
public class GyroYoli extends AvianceThread { //CREDITS GO TO ORAN FOR WRITING- I NEED THIS CODE FOR MY PACKAGE
    
    private Gyro direction = new Gyro(1);
    double angle;
    
    public void startup(){
        direction.reset();
    }
    
    protected void iteration(){
        angle = direction.getAngle();
        while(angle>=360){
            angle -= 360;
        }
    }
    
    public double getAngle(){
        return angle;
    }
}
