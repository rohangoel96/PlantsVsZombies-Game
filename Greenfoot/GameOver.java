import greenfoot.*;

/**
 * Screen shown after the game ends
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */
public class GameOver extends World
{
    // Variables Declaration
    private GreenfootSound backgroundMusic = new GreenfootSound("atebrains.wav");
    
    /**
     * Constructor for objects of class GameOver.
     */
    public GameOver(int score)
    {    
        // Create a new world with 1111x602 cells with a cell size of 1x1 pixels.
        super(1111, 602, 1); 
        backgroundMusic.play();
        Counter counter = new Counter();
        addObject(counter,613,553);
        counter.setValue(score);
        Replay replay = new Replay();
        addObject(replay, 1042, 577);
    }
    
    /**
     * Stops the background music after playing it once
     */
    public void stopBackgroundMusic()
    {
        backgroundMusic.stop();
    }
    
}


