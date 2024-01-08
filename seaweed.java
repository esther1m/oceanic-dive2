import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Makes the seaweed turn one way and the other every now and again
 * 
 * @author (OLIVIA FIELDING) 
 * @version (v1.0)
 */
public class Seaweed extends Actor
{
    /**
     * Act - do whatever the seaweed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //initial direction the seaweed will turn in
    int direction = -1;
    
    //allows the seaweed to turn around 45 degrees before switching direction
    //if the rotation is 0 or the opposite way, it will change direction again by multiplying the direction variable by -1
    public void act()
    {
        turn(6 * direction);
        if (getRotation() >= 45 || getRotation() <= -45) {
            direction *= -1;
        } else if (getRotation() == 0 || getRotation() < -45) {
            direction *= -1;
        }
    }
}
