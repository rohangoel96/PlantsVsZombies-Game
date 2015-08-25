import greenfoot.*;

/**
 * The Replay Button
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Replay extends Actor
{private GifImage gif = new GifImage("gameOver.gif");
    /**
     * Act - do whatever the click wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * Restarts the game when pressed 
     */
    public void act() 
    {
        setImage(gif.getCurrentImage());
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new StartScreen());
            GameOver world = (GameOver)getWorld();
            world.stopBackgroundMusic();
        }
    }    
}