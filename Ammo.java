import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ammo here.
 * 
 * @author (ESTHER MIKHAEL)
 * @version (v1.0)
 */
public class Ammo extends Actor
{
    //checker variable to prevent multiple collisions being detected
    boolean checker = false;

    public void act()
    {
        // act method constantly loops checkCollision so it is always running
        checkAmmoCollision();
    }

    /* checkCollision checks the collision of an Ammo object with the diver and returns true if it has collided
     * it also makes sure that there hasn't just been a collision by using the boolean condition checker
     */

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
