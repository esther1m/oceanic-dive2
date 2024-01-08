import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controls how the shipwrecked wood behaves
 * 
 * @author (ESTHER MIKHAEL) 
 * @version (a version number or a date)
 */
public class ShipwreckWood extends Actor
{
    /**
     * Act - do whatever the shipwreckWood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /* repeatedly checks if there has been a collision with itself so that they don't spawn in a cluster
     * moves the shipwrecked wood
     * sets a rotation because otherwise it looks weird
     * checks the edge so that they respawn at the top of the screen once they've reached the bottom.
     */
    public void act()
    {
        checkCollision();
        move(1);
        setRotation(90);
        checkEdge();
        
    }
    /* this method checks the edge so that they respawn at the top of the screen once they've reached the bottom.
     * uses a random x co-ordinate but the same y
     */
    private void checkEdge(){
        if (isAtEdge()){
            int randX = Greenfoot.getRandomNumber(getWorld().getWidth());
            setLocation(randX, 4);
        }
    }
/* checks collision with itself
 * if true, then the objects are moved to a new area where they are not colliding
 */
    private void checkCollision(){
        if (isTouching(getClass()) == true){
            int randX2 = Greenfoot.getRandomNumber(getWorld().getWidth());
            setLocation(randX2, 4);
        }
    }
}
