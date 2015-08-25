import greenfoot.*;

/**
 * The Walnut class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Walnut extends Plants
{
    //Variables
    private GifImage gifFullLife = new GifImage("walnut_full_life.gif");
    private GifImage gifHalfLife = new GifImage("walnut_half_life.gif");
    private GifImage gif = gifFullLife;
    private int halfLife = 5000;
   
    /**
     * Constructor for Walnut
     */
    public Walnut()
    {
        setImage(gifFullLife.getCurrentImage());
        setTimeToLive(halfLife * 2);
    }
     /**
     * Act - do whatever the zombie_normal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        plantHit("walnut_dead.gif", 1000);
        halfDead();
    }
    
    /**
     * Animating the walnut at half life
     */
    private void halfDead()
    {
        if(timeToLive < halfLife)
        {
            setImage(gifHalfLife.getCurrentImage());
        }
        else
        {
            setImage(gifFullLife.getCurrentImage());
        }
    }
}
