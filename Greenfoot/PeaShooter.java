import greenfoot.*;

/**
 * The PeaShooter Class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class PeaShooter extends Plants
{
    private GifImage gif = new GifImage("pea_shooter.gif");
    /**
     * Constructor for PeaShooter
     */
    public PeaShooter()
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
       shootPeas(2000);
       plantHit("pea_shooter_dying.gif",900);
    }
    
    private long lastAdded = System.currentTimeMillis();
    /**
     * Shoots peas
     */
    private void shootPeas(int timeInterval)
    {
        if (!getWorld().getObjects(Zombie.class).isEmpty())
        {
            long curTime  = System.currentTimeMillis();
            if (curTime >= lastAdded + timeInterval) //5000ms = 5s
            {
                lastAdded  = curTime;
                Pea pea = new Pea();
                World world = getWorld();
                world.addObject(pea, getX() + 28, getY() -11);
            }
        }
    }
}
