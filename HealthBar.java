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
    /* health status initiated to 100
     * boolean canLoseHealth initiated and set as true. this variable is to ensure that the diver doesn't
     * lose too much health if they collide with the shipwrecked wood and seaweed too fast
     * cooldown sets the time before they can lose health again
     * bar is the healthbar that is drawn and continuously updated as the health loses health
     * initialising Level1 object so that it can be used and referenced
     * initialsing the diver object so that it can be used and referenced
     */
    int health = 100;
    boolean canLoseHealth = true;
    int cooldown = 10;
    GreenfootImage bar; 
    Level1 myWorld;
    Diver diver2;

    /*getting the current world and current diver through referencing the world
     */
    public HealthBar(Level1 world) {
        myWorld = world;
        bar = new GreenfootImage(52, 12);
        
        Diver diver2 = myWorld.getDiver();

        updateHealthBar();
        
    }
    /*act method created so contents in it are repeated
     * makes sure that the diver position is constantly updated and accurate so that the healthbar is
     * constantly on top of the diver
     * makes sure that it is not accessing any methods without the Diver object existing
     * constantly updates position and checks collisions
     * healthbar is also constantly updated
     */
    public void act() {
        updateDiverPosition();
        if (diver2 != null){
            setLocation(diver2.getX() - 5, diver2.getY() - 50);
            checkWoodCollision();
            checkSeaweedCollision();
        }
        updateHealthBar();
    }
    /*methods check for wood colliding with the diver object
     * checks if the diver has not already collided with an object beforehand
     * makes sure that it hasnt and that it is currently touching a wood object
     * calls the lose health method and resets the lose health method to false
     * if it can't lose health then it will start decreasing the cooldown
     * once the cooldown reaches 0, it resets and allows the diver to lose health again
     */
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

    private void checkSeaweedCollision(){
        if (canLoseHealth && hitBySeaweed(diver2)){
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
        
        health--;
        updateHealthBar();

        if(health<=0) {
            myWorld.showText("Game Over! \n You survived for " + (myWorld.time/60) + " seconds", getWorld().getWidth()/2 , getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }

    public void updateHealthBar(){
        bar.clear();
        //setImage(bar);
        bar.drawRect(0,0,51,11);
        bar.setColor(Color.GREEN);
        bar.fillRect(1,1,health,10);
        setImage(bar);
        //return bar;
    }


    public boolean hitByshipwreckWood(Actor actor) {

        return isTouching(ShipwreckWood.class);
    }

    public boolean hitBySeaweed(Actor actor){
        return isTouching(Seaweed.class);
    }

    public void updateDiverPosition(){
        diver2 = myWorld.getDiver();
    }
}