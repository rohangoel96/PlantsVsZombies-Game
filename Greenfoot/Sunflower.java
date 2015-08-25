import greenfoot.*;


/**
 * The Sunflower class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Sunflower extends Plants
{
    private GifImage gif = new GifImage("sun_flower.gif");
    
    /**
     * Constructor for Sun Flower
     */
    public Sunflower()
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
       produceSun(4000);
       plantHit("sun_flower_dying.gif", 1000);
    }
    
    /**
     * To produce 'suns' with a time interval of timeInterval in ms
     */
    private long lastAdded = System.currentTimeMillis();
    
    public void produceSun(int timeInterval)
    {
        long curTime  = System.currentTimeMillis();
        if (curTime >= lastAdded + timeInterval) //5000ms = 5s
        {
            lastAdded  = curTime;
            Sun sun = new Sun();
            World world = getWorld();
            if(world.getObjectsAt(getX() + 30, getY() + 30, Sun.class).isEmpty())
            {
                world.addObject(sun, getX() + 30, getY() + 30);
            }
        }
    }
}
