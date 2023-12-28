import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KrabbyPatty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KrabbyPatty extends Actor
{
    int count = 0;
    boolean outcome = false;
    /**
     * Act - do whatever the KrabbyPatty wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        checkCollision();
    }

    public boolean checkCollision() {
        if (isTouching(Diver.class)) {
            outcome =  true;
            count++;
        }
        return outcome;
    }
}
