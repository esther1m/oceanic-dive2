import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * playbutton functionality to start the game
 * 
 * @author (ESTHER MIKHAEL) 
 * @version (v1.0)
 */
public class PlayButton extends Actor
{
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        
        // when the play button image is clicked on, it will take you to the storyline screen
        if (Greenfoot.mouseClicked(this) == true) {
            Greenfoot.setWorld(new Storyline());
        } 
    }

}
