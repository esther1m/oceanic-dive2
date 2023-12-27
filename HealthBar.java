import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 50;
    public HealthBar() {
        updateHealthBar();
        
    }
    public void act()
    {

        MyWorld myWorld = new MyWorld();
        setLocation(myWorld.diver.getX() - 5, myWorld.diver.getY() - 50);
        loseHealth();
    }
    public void loseHealth() {
        MyWorld myWorld = new MyWorld();
        if (hitByshipwreckWood(myWorld.diver) == true) {
            health--;
            updateHealthBar();
        }
        if(health<=0) {
            //getWorld().showText("Game Over! \n You survived for " + (myWorld.diver.time/60) + " seconds", getWorld().getWidth()/2 , getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }

    public GreenfootImage updateHealthBar(){
        GreenfootImage bar = new GreenfootImage(52, 12);
        setImage(bar);
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.GREEN);
        getImage().fillRect(1,1,health,10);
        return bar;
    }


    public boolean hitByshipwreckWood(Actor actor) {
        if (isTouching(ShipwreckWood.class) == true) {
            return true;
        } else {
           return false;
        }
    }
}