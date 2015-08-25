import greenfoot.*;

/**
 * The bullet type shot by beetroot
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Beet extends Bullet
{
    public Beet()
    {
        setSpeed(6);
    }
    
    /**
     * Act - do whatever the Beet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(speed);
        checkBoundaries();
    }    
}
