import greenfoot.*;

/**
 * The Bullet Class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Bullet extends Actor
{
    protected int speed = 4;
    
    /**
     * Sets the speed of the bullet
     */
    protected void setSpeed(int bulletSpeed)
    {
        speed = bulletSpeed;
    }    
    
    /**
     * Removes the bullet if it reaches the right edge of the screen
     */
    protected void checkBoundaries()
    {
        if(getX() > getWorld().getWidth() - 10)
            getWorld().removeObject(this);       
    }
}
