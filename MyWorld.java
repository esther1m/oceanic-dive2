import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private static final int NUMBER_OF_SHIPWRECK = 7;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        
        
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        //populating the world with pieces of wood
        populate();
    }
        
    public void populate(){
        addObject(new Diver(), 500 ,556);
        for (int i = 0; i < NUMBER_OF_SHIPWRECK; i++){
            int x = Greenfoot.getRandomNumber(getWidth());
            addObject(new shipwreckWood(), x, 4);
        }

    }
}
