/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.Cory;
 
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import modules.oran.GyroOran;



/**
 *
 * @author samuels1/Cory
 */
public class SlingshotRobot extends GyroOran{
                       
            Joystick left = new Joystick(1);
            Joystick right = new Joystick(2);
            
            //drive objects
            Jaguar bl = new Jaguar(1);
            Jaguar br = new Jaguar(2);
            Jaguar fl = new Jaguar(3);
            Jaguar fr = new Jaguar(4);
            
            //Slingshot objects
            Jaguar beltJag = new Jaguar(5);
            DoubleSolenoid beltSol = new DoubleSolenoid(6,7);
            
            double delay = 1;
            
            
            public void startup(){

            }


            protected void iteration(){
                
                    boolean tRight = right.getRawButton(2);
                    boolean tLeft = right.getRawButton(3);

                    double leftvalue;
                    double rightvalue;

                    leftvalue = left.getY();
                    rightvalue = right.getY();

                    bl.set(leftvalue);
                    fl.set(leftvalue);
                    br.set(-1 * rightvalue);
                    fr.set(-1 * rightvalue);
                    
                    
                    
                    if(tLeft) {
                        double less = angle + 315;
                        if (less >= 360){
                            less -= 360;
                        }
                        
                        while (angle < less){
                        leftvalue = -1;
                        rightvalue = 1;   
                        
                        bl.set(leftvalue);
                        fl.set(leftvalue);
                        br.set(-1 * rightvalue);
                        fr.set(-1 * rightvalue);   
                        }
                        
                        Timer.delay(delay);
                        if (tLeft) {
                            leftvalue = -1;
                            rightvalue = 1;
                        
                            bl.set(leftvalue);
                            fl.set(leftvalue);
                            br.set(-1 * rightvalue);
                            fr.set(-1 * rightvalue);
                        }
                    }

                    if(tRight) {
                        double less1 = angle + 45;
                        if (less1 >= 360){
                            less1 -= 360;
                        }
                        
                        while (angle < less1){
                        leftvalue = 1;
                        rightvalue = -1;
                        
                        bl.set(leftvalue);
                        fl.set(leftvalue);
                        br.set(-1 * rightvalue);
                        fr.set(-1 * rightvalue);
                        }
                        
                        Timer.delay(delay);
                        if (tRight) {
                            leftvalue = 1;
                            rightvalue = -1;

                            bl.set(leftvalue);
                            fl.set(leftvalue);
                            br.set(-1 * rightvalue);
                            fr.set(-1 * rightvalue);
                            
                            //code for the slingshot
                            boolean ssButton = right.getRawButton(1);
                            
                            
                            
                            if(ssButton){
                                beltJag.set(1);
                                beltSol.set(DoubleSolenoid.Value.kForward);
                                
                                if(!(ssButton)){
                                    beltSol.set(DoubleSolenoid.Value.kReverse);
                                }
                            }
                           
                        }
                    }

           }

            public void reset(){

            }
    
}
