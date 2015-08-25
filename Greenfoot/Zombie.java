import greenfoot.*;

/**
 * The Zombie class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Zombie extends Actor
{
    //Variable declaration
    protected int zombieSpeed;
    protected int zombieHealth;   
    protected GreenfootSound comingZombie = new GreenfootSound("zombies_coming.wav");
    protected static boolean gameOver = false;
    protected static int zombieCount = 0;
    
    /**
     * Constructor for Zombie Class , plays sound when the first zombie comes 
     */
    public Zombie()
    {   
        if(zombieCount==0)
        {
            comingZombie.play();
        }
        zombieCount+=1;
    }
    
   
    /**
     * This method sets the speed of a zombie object
     */
    
    protected void setSpeed(int speed)
    {
        if(isTouching(Plants.class))
        {
            zombieSpeed = 0;
        }
        else
        {
            zombieSpeed = speed;
        }
    }
    
    /**
     * This method sets the health of a zombie object
     */
    protected void setHealth(int health)
    {
        zombieHealth = health;
    }
    
    /**
     * This method is called whenever a zombie is hit by an object of the bullet class.
     * It takes four inputs:
     * 1. the damage caused by the bullet, which is reduced from its health,
     * 2. the filename where the animation for its removal is stored,
     * 3. the time of a loop of the gif, and
     * 4. the points for killing the zombie
     */
    protected void zombieHit(int damage, String filename, int timeLoop, int points)
    {   
        if(isTouching(Bullet.class))
        {
            zombieHealth -= damage;
            removeTouching(Bullet.class);
        }
        
        if(zombieHealth <= 0)
            {
                removeTouching(Bullet.class);                
                dyingZombieAnimation(filename,timeLoop);
                
                Backyard world = (Backyard)getWorld();
                Counter score = world.getScoreCounter();
                score.add(points);
                world.removeObject(this);
            }
    }
    
    /**
     * This class is related to the animation part of the the zombie being removed from the screen
     */
    protected void dyingZombieAnimation(String filename,int timeLoop)
    {
        DeadActor dead = new DeadActor(filename,timeLoop);
        World world = getWorld();
        world.addObject(dead, getX(), getY());
    }
    
    /**
     * Checks if any Zombie crosses the garden and enters the house and ends the game
     */
    protected void checkGameOver()
    {
        Backyard world = (Backyard)getWorld();
        int column = world.returnGridColumnPosition(getX());
        if(getX() < 260)
        {   
            setHealth(-1);
            Counter score = world.getScoreCounter();          
            world.stopBackgroundMusic();
            gameOver = true;
            Greenfoot.setWorld(new GameOver(score.getValue()));            
            
        }
    }
}
