import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (ESTHER MIKHAEL) 
 * @version (v1.2)
 */
public class Shield extends Actor
{
    /**
     * Act - do whatever the Shield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    /*  initialising the variables time and checker
        time allows the shield to stay up for a certain amount of time (45 seconds) */

    int time = 0;
    boolean checker = false;

    /* initialising objects from other classes in order to use their methods and variables */

    Level1 myWorld;
    Diver diver3;
    HealthBar health;
   
    /* the contsructor class for shield, allowing it to interact with the current instances or objects that are already in the world, 
     * not creating new instances of them 
    */
    
    public Shield(Level1 world) {
        myWorld = world;        
        diver3 = myWorld.getDiver();
        health = myWorld.getHealthBar();
    }

    /* act method - keeps the time running (inside the class) and the position of the diver updated.
     * it also makes it so that, when called, the shield makes sure the diver cannot lose health until 
     * the timer is up.
     * 
     * once the timer is up, it resets any variables used 
     * the variable checker is then used by the world class to check if the shield duration is over and then execute code that way
     */

    public void act() {
        time++;
        updateDiverPosition();
        if (diver3 != null){
            setLocation(diver3.getX() -101, diver3.getY() - 43);
            setRotation(diver3.getRotation());
            if (getRotation() > 180) {
                setLocation(diver3.getX() -38, diver3.getY() +100);
            }
            else if (getRotation() > 90){
                setLocation(diver3.getX() + 100, diver3.getY() + 38);
            }
            else if (getRotation() > 0) {
                setLocation(diver3.getX() +43, diver3.getY()-101);
            }
        }

        health.canLoseHealth = false;
        health.cooldown = 150;

        if (time/60 >= 45){
            time =0;
            myWorld.foodCount = 0;
            checker = true;
        }
    }

    /* method to constantly update the diver's position */

    public void updateDiverPosition(){
        diver3 = myWorld.getDiver();
    }
}