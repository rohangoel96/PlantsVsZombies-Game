import greenfoot.*;


/**
 * The Plant Class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Plants extends Actor
{   
    //variables declaration
    GreenfootSound plantEaten = new GreenfootSound("chomp.wav");
    protected int timeToLive = 2000; 
    
    /**
     *  Sets the life of the plant
     */
    protected void setTimeToLive(int time)
    {
        timeToLive = time;
    }
    
    /**
     * Checks if the zombie is eating up the plant
     */
    protected void plantHit(String filename, int timeLoop)
    {
        if(isTouching(Zombie.class))
        {
            timeToLive -= 20;
            plantEaten.play();
        }
        
        if (timeToLive < 0)
        {
            World world = getWorld();
            dyingPlantAnimation(filename,timeLoop);
            world.removeObject(this);
            plantEaten.stop();
        }
    }
    
    /**
     * Plays the animation when the plant dies
     */
    protected void dyingPlantAnimation(String filename,int timeLoop)
    {
        DeadActor dead = new DeadActor(filename,timeLoop);
        World world = getWorld();
        world.addObject(dead, getX(), getY());
    }
}
