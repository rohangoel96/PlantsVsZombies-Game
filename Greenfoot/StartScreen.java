import greenfoot.*;

/**
 * The screen shown on startup
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class StartScreen extends World
{
    //variable declaration
    private GreenfootSound background = new GreenfootSound("menu.wav");
    
    /**
     * Constructor for objects of class StartScreen.
     */
    public StartScreen()
    {    
        // Create a new world with 1111x602 cells with a cell size of 1x1 pixels.
        super(1111, 602, 1); 
        prepare();
        background.playLoop();
    }
    
    /**
     * Stops the background music once the screen is changed
     */
    public void stopBackgroundMusic()
    {
        background.stop();
    }
    
    /**
     * Adds a button to the screen on start up which starts the game
     */
    private void prepare()
    {  
        ClickToStart start = new ClickToStart();
        addObject(start, 641, 534);   
    }
}
