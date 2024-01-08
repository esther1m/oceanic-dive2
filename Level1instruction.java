import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shows the screen of the instructions for level 1
 * 
 * @author (ESTHER MIKHAEL) 
 * @version (v1.0)
 */
public class Level1Instruction extends World
{

    /**
     * Constructor for objects of class Level1instruction.
     * 
     */
    public Level1Instruction()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        act();
    }
    //waits for the user to click and then changes the world to start level 1
    public void act() {
        showText("Click anywhere to START LEVEL 1 ", 500 , 571);
        if (Greenfoot.mouseClicked(this) == true) {
            Greenfoot.setWorld(new Level1());
        }
    }
}
