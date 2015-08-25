import greenfoot.*;

/**
 * SunFlower icon class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class SunFlowerIcon extends Sidebar
{   
    /**
     * The constructor sets the images for both active and inactive states along with the cost and position
     */
    public SunFlowerIcon(int positionX, int positionY)
    {
        setCostOfPlant(50);
        setIconCoordinates(positionX, positionY);
        setActiveImage("active_sunflower.png");
        setInactiveImage("inactive_sunflower.png");
    }
    
    public void act() 
    {
        createPlant(new Sunflower());
    }    
}
