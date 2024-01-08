import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the first screen you can see when you open the game.
 * 
 * @author (ESTHER MIKHAEL) 
 * @version (v1.0)
 */
public class Welcome extends World
{
    // initiates a playbutton, when clicked you can progress
    PlayButton button = new PlayButton();
    

    /**
     * Constructor for objects of class Welcome.
     * 
     */
    public Welcome()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        addObject(button, 495, 474);
        
    }

    
}
