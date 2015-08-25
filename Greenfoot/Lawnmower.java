import greenfoot.*;

/**
 * Lawnmover Class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Lawnmower extends Actor
{
    //variable declaration
    private GifImage gif = new GifImage("lawn_mower.gif");
    private int speed = 0;
    GreenfootSound sound = new GreenfootSound("lamborghini.wav");
    
    /**
     * Setting the image in the constructor
     */
    public Lawnmower()
    {
        setImage(gif.getCurrentImage());    
    }
    
    /**
     * The act method is called by the greenfoot framework to give actors a chance to perform some action.
     * Here it moves the lawn mover if zombie reaches the last column , killing any zombies in the way
     */
    public void act()
    {
        move(speed);
        if(isTouching(Zombie.class))
        {
            removeTouching(Zombie.class);
            speed = 12;
            sound.play();
        }
        if(speed > 0)
        {                      
            setImage(gif.getCurrentImage());
        }
        checkBoundaries();
    }    
    
    /**
     * Removes the lawnmover from the world if it reaches the right edge
     */
    protected void checkBoundaries()
    {
        if(getX() > getWorld().getWidth() - 10)
            getWorld().removeObject(this);       
    }
}
