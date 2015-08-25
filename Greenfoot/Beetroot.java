import greenfoot.*;

/**
 * The Beetroot plant class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Beetroot extends Plants
{
    private GifImage gif = new GifImage("beetroot.gif");
    /**
     * Constructor for BeetRoot
     */
    public Beetroot()
    {
        setImage(gif.getCurrentImage());    
    }
     /**
     * Act - do whatever the zombie_normal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setImage(gif.getCurrentImage());
       shootBeet(2000);
       plantHit("beetroot_dying.gif", 1000);
    }
    
    private long lastAdded = System.currentTimeMillis();
    /**
     * Make the plant shoots beet
     */
    private void shootBeet(int timeInterval)
    {
        if (!getWorld().getObjects(Zombie.class).isEmpty())
        {
            long curTime  = System.currentTimeMillis();
            if (curTime >= lastAdded + timeInterval) //5000ms = 5s
            {
                lastAdded  = curTime;
                Beet beet = new Beet();
                World world = getWorld();
                world.addObject(beet, getX() + 29, getY() + 20);
            }
        }
    }
}
