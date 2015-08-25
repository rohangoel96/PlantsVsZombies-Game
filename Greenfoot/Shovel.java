import greenfoot.*;

/**
 * The shovel class used to remove plants
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Shovel extends Actor
{
    protected boolean isGrabbed;
    protected int iconX , iconY;
    
    /**
     * Connstructor for shovel placing it in the right position
     */
    public Shovel(int posX, int posY)
    {
        iconX = posX;
        iconY = posY;
    }
    
    /**
     * The act method is called by the greenfoot framework to give actors a chance to perform some action.
     */
    public void act() 
    {
        removePlant();
    }
    
    /**
     * Removes the plant if the shovel touches it
     * Also implemetns the dragging feature
     */
    private void removePlant()
    {
        Backyard world = (Backyard)getWorld();
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
            
            int plantRow = (mi.getY());
            int plantColumn = (mi.getX());
                if(!world.getObjectsAt(plantColumn, plantRow, Actor.class).isEmpty())
                {
                    removeTouching(Plants.class);
                }
                
            setLocation(iconX, iconY);
            isGrabbed = false;
            return;
        }
    }
}
