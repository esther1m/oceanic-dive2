import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1instruction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1Instruction extends World
{

    /**
     * Constructor for objects of class Level1instruction.
     * 
     */
    public Level1Instruction()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        act();
    }

    public void act() {
        showText("Click anywhere to START LEVEL 1 ", 500 , 571);
        if (Greenfoot.mouseClicked(this) == true) {
            Greenfoot.setWorld(new Level1());
        }
    }
}
