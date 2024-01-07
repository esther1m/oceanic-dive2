import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KrabbyPatty here.
 * 
 * @author (ESTHER MIKHAEL)
 * @version (v1.0)
 */
public class KrabbyPatty extends Actor
{
    /* initialising the variables count and outcome
     * count helps keep track of how many krabby patties are eaten by the diver
     * outcome helps keep track of if the diver has eaten the krabby patty or not
     */

    int count = 0;
    boolean outcome = false;

    /**
     * Act - do whatever the KrabbyPatty wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        // act method constantly loops checkCollision so it is always running
        checkCollision();
    }

    /* checkCollision checks the collision of a Krabby Patty object with the diver and returns true if it has collided */

    public boolean checkCollision() {
        if (isTouching(Diver.class)) {
            outcome =  true;
            count++;
        }
        return outcome;
    }
}
