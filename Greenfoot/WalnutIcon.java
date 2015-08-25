import greenfoot.*;


/**
 * Walnut Icon class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class WalnutIcon extends Sidebar
{
    /**
     * The constructor sets the images for both active and inactive states along with the cost and position
     */
    public WalnutIcon(int positionX, int positionY)
    {
        setCostOfPlant(25);
        setIconCoordinates(positionX, positionY);
        setActiveImage("active_walnut.png");
        setInactiveImage("inactive_walnut.png");
    }
    
    public void act()
    {
        createPlant(new Walnut());
    }    
}
