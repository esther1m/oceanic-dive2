import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ammo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ammo extends Actor
{
    /**
     * Act - do whatever the Ammo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    boolean checker = false;

    /**
     * Act - do whatever the KrabbyPatty wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        // act method constantly loops checkCollision so it is always running
        checkAmmoCollision();
    }

    /* checkCollision checks the collision of a Krabby Patty object with the diver and returns true if it has collided */

    public boolean checkAmmoCollision() {
        if (checker && !isTouching(Diver.class)) {
            checker =  false;
        }  
        if (!checker && isTouching(Diver.class)){
            checker = true;
        }
        return checker;
    }
}
