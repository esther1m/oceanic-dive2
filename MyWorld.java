import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //initialising the amount of shipwrecks to be repeated and the amount of seaweed to be in the game
    private static final int NUMBER_OF_SHIPWRECK = 7;
    private static final int NUMBER_OF_SEAWEED = 10;
    int time = 0;
    Diver diver = new Diver();
    HealthBar healthBar = new HealthBar(this);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {            
        
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        Greenfoot.setSpeed(60);
        populate();

        
    }
        
    public void populate(){

        addObject(diver, 500 ,556);
        addObject(healthBar, diver.getX() - 5, diver.getY() - 50);

        for (int i = 0; i < NUMBER_OF_SHIPWRECK; i++){
            int x = Greenfoot.getRandomNumber(getWidth());
            addObject(new ShipwreckWood(), x, 4);
        }

        for (int count = 0; count < NUMBER_OF_SEAWEED; count++){
            int randomX = Greenfoot.getRandomNumber(getWidth());
            int randomY = (Greenfoot.getRandomNumber(99) + 500);
            addObject(new seaweed(), randomX, randomY);
        }

    }

    public void act() {
        time++;
        checkNextLevel();
    }

    public void checkNextLevel() {
        if (time/60 == 240 || time/60 >= 240){
            showText("Success! You beat Level 1! ", getWidth()/2 ,getHeight()/2);
            Greenfoot.stop();
        }
    }

    public Diver getDiver(){
        return diver;
    }
    
    public HealthBar getHealthBar() {
        return healthBar;
    }

}
