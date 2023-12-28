import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //int health = 50;
    private boolean canLoseHealth = true;
    private int cooldown = 10;

    MyWorld myWorld;
    Diver diver3;
    HealthBar health;

    
    public Shield(MyWorld world) {
        myWorld = world;
    
        
        diver3 = myWorld.getDiver();

        health = myWorld.getHealthBar();
        
    }
/* 
    public void act() {
        updateDiverPosition();
        if (diver2 != null){
            setLocation(diver2.getX() - 5, diver2.getY() - 50);
            checkWoodCollision();
        }
    }

    private void checkWoodCollision(){
        if (canLoseHealth && hitByshipwreckWood(diver2)){
            loseHealth();
            canLoseHealth = false;
        } else if (! canLoseHealth) {
            cooldown--;
            if (cooldown <= 0) {
                cooldown = 30;
                canLoseHealth = true;
            }
        }
    }

    public void loseHealth() {
        if (hitByshipwreckWood(diver2) == true) {
            health--;
            updateHealthBar();
        }
        if(health<=0) {
            myWorld.showText("Game Over! \n You survived for " + (myWorld.time/60) + " seconds", getWorld().getWidth()/2 , getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }




    public boolean hitByshipwreckWood(Actor actor) {

        return isTouching(ShipwreckWood.class);
    }

    public void updateDiverPosition(){
        diver2 = myWorld.getDiver();
    }
}
*/}