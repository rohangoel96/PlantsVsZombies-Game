import greenfoot.*;

/**
 * Pea Shooter Icon Class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class PeaShootIcon extends Sidebar
{   
     /**
     * The constructor sets the images for both active and inactive states along with the cost and position
     */
    public PeaShootIcon(int positionX, int positionY)
    {
        setCostOfPlant(100);
        setIconCoordinates(positionX, positionY);
        setActiveImage("active_peashooter.png");
        setInactiveImage("inactive_peashooter.png");
    }
    
    public void act() 
    {
        createPlant(new PeaShooter());
    }    
}

