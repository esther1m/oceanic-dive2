import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * shows the objects used in level 1 and takes the user to the next screen 
 * 
 * @author (ESTHER MIKHAEL) 
 * @version (v1.0)
 */
public class Level1Objects extends World
{

    /**
     * Constructor for objects of class intro2.
     * 
     */
    public Level1Objects()
    {    
       // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
       super(1000, 600, 1); 
       act();
    }
    //waits for the user click to take them to the instruction page
    public void act() {
        showText("Click anywhere to continue ", 500 , 571);
        if (Greenfoot.mouseClicked(this) == true) {
            Greenfoot.setWorld(new Level1Instruction());
        }
    }
    
}
