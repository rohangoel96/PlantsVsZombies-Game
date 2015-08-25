import greenfoot.*;

/**
 * The Dead Actor class handles animation of dead actors
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class DeadActor extends Actor
{
    private GifImage gif;
    private int loopTime;
    /**
     * Constructor of DeadActor 
     */
    public DeadActor(String filename, int timeforloop)
    {
        gif = new GifImage(filename);
        setImage(gif.getCurrentImage());
        loopTime = timeforloop;
    }
    
    private long lastAdded = System.currentTimeMillis();    
    /**
     * Removes the dead plant after the dying animation
     */
    public void act() 
    {
        long curTime  = System.currentTimeMillis();
        setImage(gif.getCurrentImage());
        if (curTime >= lastAdded + loopTime) //5000ms = 5s
        {
            lastAdded  = curTime;
            getWorld().removeObject(this);            
        }
    }   
}
