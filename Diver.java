import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diver here.
 * 
 * @author (ESTHER MIKHAEL) 
 * @version (v1.0)
 */
public class Diver extends Actor
{
    /**
     * Act - do whatever the Diver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //moves the diver with the keys
        if(Greenfoot.isKeyDown("D"))
        {
            setRotation(0);
            move(1);
        }
        if(Greenfoot.isKeyDown("S"))
        {
            setRotation(90);
            move(1);
        }
        if(Greenfoot.isKeyDown("A"))
        {
            setRotation(180);
            move(1);
        }
        if(Greenfoot.isKeyDown("W"))
        {
            setRotation(270);
            move(1);
        }
    }
}
