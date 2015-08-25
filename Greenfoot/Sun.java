import greenfoot.*;


/**
 * The sun (currency of the game) class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Sun extends Actor
{
    private GifImage gif = new GifImage("sun.gif");
    private boolean sunFall = false;
    private int sunSpeed = 2;
    /**
     * Constructor for Sun
     */
    public Sun()
    {
        setImage(gif.getCurrentImage());        
    }
    
    /**
     * Act method for the sun, checks if the sun is collected and then adds up 25 to sun_counter
     */
    public void act() 
    {
       setImage(gif.getCurrentImage());
        
        if(sunFall == true)
        {
            sunDrop();
        }
       
        if (Greenfoot.mouseClicked(this))
        {
            Backyard world = (Backyard)getWorld();
            Counter sunCounter = world.getSunCounter();
            sunCounter.add(25);
            world.removeObject(this);
        }
    }
    
    /**
     * Stops the sun when it reaches the bottom of the screen
     */
    private void sunDrop()
    {
        move(sunSpeed);
        if(getY() >= getWorld().getHeight() - 30)
            sunSpeed = 0;
    }
    
    /**
     * Enables the sun to fall
     */
    public void letTheSunFall()
    {
        sunFall = true;        
        turn(90);
    }
}
