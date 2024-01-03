import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Welcome here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Welcome extends World
{

    /**
     * Constructor for objects of class Welcome.
     * 
     */
    public Welcome()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        PlayButton button = new PlayButton();
        addObject(button, 495, 474);
    }

   /*  public void act() {
        if (Greenfoot.mouseClicked(this) == true) {
            Greenfoot.setWorld(new World2());
        }
    }*/
}
