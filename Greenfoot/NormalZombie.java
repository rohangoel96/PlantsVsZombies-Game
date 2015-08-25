import greenfoot.*;

/**
 * The Normal Zombie Class 
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class NormalZombie extends Zombie
{
    private GifImage gif = new GifImage("zombie_normal.gif");
    /**
     * Constructor for Zombie
     */
    public NormalZombie()
    {
        setImage(gif.getCurrentImage());
        setHealth(100);
    }
     /**
     * Act - do whatever the zombie_normal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(gif.getCurrentImage());
        move(zombieSpeed);
        checkGameOver();
        setSpeed(-1);
        zombieHit(25, "zombie_normal_dying.gif", 800, 10);       
    }    
}
