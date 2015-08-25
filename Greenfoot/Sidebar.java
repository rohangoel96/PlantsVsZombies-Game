import greenfoot.*;

/**
 * The Sidebar class handles all the icons of the plants
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Sidebar extends Actor
{
    //variable declaration
    protected int costOfPlant;
    protected boolean isGrabbed, isActive = false;
    protected int iconX, iconY;
    protected GreenfootImage activeImage, inactiveImage;
    
    /**
     * Sets the cost of each plant in terms of sun
     */
    protected void setCostOfPlant(int cost)
    {
        costOfPlant = cost;
    }
    
    /**
     * Sets the position of the icon on the sidebar
     */
    protected void setIconCoordinates(int x, int y)
    {
        iconX = x;
        iconY = y;
    }    
    
    /**
     * To create a plant
     */
    protected void createPlant(Plants plant)
    {
        Backyard world = (Backyard)getWorld();
        Counter sunCounter = world.getSunCounter();
        if(costOfPlant <= sunCounter.getValue())
        {
            setImage(activeImage);
            createPlantDragAndDrop(plant, world, sunCounter);
        }
        else
        {
            setImage(inactiveImage);
        }
    }
    
    /**
     * The logic for the Drag and Drop is in this function.
     */
    protected void createPlantDragAndDrop(Plants plant, Backyard world, Counter sunCounter)
    {
        /* in the 'act' method in the class of the Actor object to be dragged */
        // check for initial pressing down of mouse button
        if (Greenfoot.mousePressed(this) && !isGrabbed)
        {
            // grab the object
            isGrabbed = true;
            // the rest of this block will avoid this object being dragged UNDER other objects
            //World world = getWorld();
            MouseInfo mi = Greenfoot.getMouseInfo();
            world.removeObject(this);
            world.addObject(this, mi.getX(), mi.getY());
            return;
        }
        // check for actual dragging of the object
        if ((Greenfoot.mouseDragged(this)) && isGrabbed)
        {
            // follow the mouse
            MouseInfo mi = Greenfoot.getMouseInfo();
            setLocation(mi.getX(), mi.getY());
            return;
        }
        // check for mouse button release
        if (Greenfoot.mouseDragEnded(this) && isGrabbed)
        {
            // release the object
            //World world = getWorld();
            MouseInfo mi = Greenfoot.getMouseInfo();
            setLocation(iconX, iconY);
            int plantRow = world.returnGridRowPosition(mi.getY());
            int plantColumn = world.returnGridColumnPosition(mi.getX());
            if(plantRow != -1 && plantColumn != -1)
            {
                if(world.getObjectsAt(plantColumn, plantRow, Actor.class).isEmpty())
                {
                    world.addObject(plant, plantColumn, plantRow);
                    sunCounter.add(-costOfPlant);
                }
                
            }
            isGrabbed = false;
            return;
        }
    }
    
    /**
     * Sets colorful image of the icon when it can be bought
     */
    protected void setActiveImage(String activeImageLink)
    {
        activeImage = new GreenfootImage(activeImageLink);
    }
    
    /**
     * Sets the grayscale image of the icon when it can't be bought 
     */
    protected void setInactiveImage(String inactiveImageLink)
    {
        inactiveImage = new GreenfootImage(inactiveImageLink);
    }
    
}
