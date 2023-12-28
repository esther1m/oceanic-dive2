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
    int time = 0;
    boolean checker = false;

    MyWorld myWorld;
    Diver diver3;
    HealthBar health;
   

    
    public Shield(MyWorld world) {
        myWorld = world;        
        diver3 = myWorld.getDiver();
        health = myWorld.getHealthBar();

        
    }
    public void act() {
        time++;
        updateDiverPosition();
        if (diver3 != null){
            setLocation(diver3.getX(), diver3.getY());
            //checkWoodCollision();
        }
        health.canLoseHealth = false;
        health.cooldown = 150;

        if (time/60 >= 45){
            time =0;
            myWorld.foodCount = 0;
            checker = true;
        }
    }

    public void updateDiverPosition(){
        diver3 = myWorld.getDiver();
    }
}