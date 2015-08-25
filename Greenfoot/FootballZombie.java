import greenfoot.*;

/**
 * The Football zombie class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class FootballZombie extends Zombie
{
    //variable declaration
    private GifImage gif = new GifImage("zombie_football.gif");
    /**
     * Constructor for Zombie
     */
    public FootballZombie()
    {
        setImage(gif.getCurrentImage());
        setHealth(100);
    }
     /**
     * Act - do whatever the zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(gif.getCurrentImage());
        move(zombieSpeed);
        checkGameOver();
        setSpeed(-1);
        zombieHit(20, "zombie_football_dying.gif", 600, 20);       
    }
}
