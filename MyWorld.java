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
    int timeInternal = 0;
    int benchmark =10;
    int foodCount = 0;
    boolean foodPresent = false;

    Diver diver = new Diver();
    HealthBar healthBar = new HealthBar(this);
    KrabbyPatty food = new KrabbyPatty();
    Shield shield = new Shield(this);
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
        timeInternal++;
        checkNextLevel();

        if (timeInternal/ 60 >= benchmark) {
            if (foodPresent) {
                removeObject(food);
                benchmark = 5; // Wait for 5 seconds next time
                timeInternal = 0;
                foodPresent = false;
            } else {
                int randx = Greenfoot.getRandomNumber(getWidth());
                int randy = Greenfoot.getRandomNumber(getHeight());
                food = new KrabbyPatty();
                addObject(food, randx, randy);
                foodPresent = true;
                benchmark = 30; // Wait for 30 seconds next time
                timeInternal =0;
            }
        }

        if (food!= null && foodPresent) {
            if (food.checkCollision()){
                benchmark = 1;
                foodCount++;
                food.outcome = false;
            }
            
        }

        if (foodCount >= 5) {
            timeInternal = 0;
            shield.setLocation(diver.getX(), diver.getY());
            addObject(shield, diver.getX(), diver.getY());
            removeObject(food);
            foodPresent = false;
            benchmark = 10000;
            foodCount = 0; 
        }

        if (shield!= null) {
            if (shield.checker){
                food.outcome = false;
                benchmark = 30; // Wait for 30 seconds next time
                timeInternal =0;
                removeObject(shield);
                healthBar.canLoseHealth = true;
                healthBar.cooldown = 30;
                shield.checker = false;
                
            }
        }

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

    public KrabbyPatty getKrabbyPatty() {
        return food;
    }

}
