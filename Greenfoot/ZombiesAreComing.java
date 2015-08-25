import greenfoot.*;

/**
 * Wave icon 
 * Shows the image and plays the sound at the starting of the wave
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZombiesAreComing extends Actor
{
    private GreenfootSound comingZombie = new GreenfootSound("zombies_coming.wav");    
    private long lastAdded;
    
    public ZombiesAreComing()
    {
        comingZombie.play();
        lastAdded = System.currentTimeMillis();
    }
    
    public void act() 
    {
        long curTime  = System.currentTimeMillis();
        if (curTime >= lastAdded +1500)
            getWorld().removeObject(this);        
    }    
}
