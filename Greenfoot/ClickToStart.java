import greenfoot.*;

/**
 * Button at the start screen
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class ClickToStart extends Actor
{
    private GifImage gif = new GifImage("click_to_start.gif");
    /**
     * Act - do whatever the click wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(gif.getCurrentImage());
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Backyard());
            StartScreen world = (StartScreen)getWorld();
            world.stopBackgroundMusic();
        }
    }    
}
