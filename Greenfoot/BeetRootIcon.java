import greenfoot.*;


/**
 * Beetroot Icon class
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class BeetRootIcon extends Sidebar
{   
    /**
     * The constructor sets the images for both active and inactive states along with the cost and position
     */
    public BeetRootIcon(int positionX, int positionY)
    {
        setCostOfPlant(125);
        setIconCoordinates(positionX, positionY);
        setActiveImage("active_beetroot.png");
        setInactiveImage("inactive_beetroot.png");
    }
    
    public void act()
    {
        createPlant(new Beetroot());
    }    
}


