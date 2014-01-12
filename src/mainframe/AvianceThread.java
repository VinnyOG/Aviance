/*
 */
package mainframe;

/**
 *
 * @author pawel
 */
public class AvianceThread extends Thread{
    
    protected boolean interrupted;
    protected long sleepTime = 30; //10 is really small.. now lets do a CPU percent test
    
    public AvianceThread(){
        super();
        interrupted = false;
    }
    
    /**
     * AvianceSleep
 
 Sleeps the thread while being aware of possible interrupts
 If an interrupt does occur an exception is thrown
     * 
     * @param sleepTime
     * @throws AvianceThreadInterruptedException 
     */
    protected void AvianceSleep(long sleepTime) throws AvianceThreadInterruptedException{
        if (interrupted){
            throw new AvianceThreadInterruptedException();
        }
        try{
            Thread.sleep(sleepTime);
        }
        catch(InterruptedException e){
            throw new AvianceThreadInterruptedException();
        }
    }
    
    public void interrupt(){
        if(isAlive()){
            interrupted = true;
            super.interrupt();
        }
    }
    
    /**
     * All threads extending this class must override this method to add functionality
 This is just a template but AvianceSleep *MUST* be invoked instead of sleep()
 and all user code *MUST* be placed in side a try-catch block catching AvianceThreadInterruptedException
 and ceasing all robot operations while cleaning up. At he end of the catch block where AvianceThreadInterruptedException is caught,
     * user must set the interrupt flag to false (interrupt = false) otherwise the thread will NOT restart***
     */
    public void run(){
       turnOn();
        try{
            while(true){
                iteration();
                AvianceSleep(sleepTime);
            }
        }
        catch(AvianceThreadInterruptedException e){
            turnOff();
            interrupted = false;
        }
    }
    
    protected void iteration() throws AvianceThreadInterruptedException{
        
    }
    
    protected void turnOn(){
        
    }
    
    protected void turnOff(){
        
    }
}
