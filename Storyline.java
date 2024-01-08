import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * shows the user the storyline of the game, and changes to the next screen
 * 
 * @author (ESTHER MIKHAEL) 
 * @version (v1.0)
 */
public class Storyline extends World
{

    /**
     * Constructor for objects of class World2.
     * 
     */
    public Storyline()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        act();
    }
    /*when the user clicks, they're taken to the next screen (the objects) */
    public void act() {
        showText("Click anywhere to continue ", 500 , 571);
        if (Greenfoot.mouseClicked(this) == true) {
            Greenfoot.setWorld(new Level1Objects());
        }
    }
}
