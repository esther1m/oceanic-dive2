import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (ESTHER MIKHAEL) 
 * @version (v1.5)
 */
public class Level1 extends World
{
    //initialising the amount of shipwrecks to be repeated and the amount of seaweed to be in the game
    private static final int NUMBER_OF_SHIPWRECK = 7;
    private static final int NUMBER_OF_SEAWEED = 10;

    /* intialising the variables time, timeInternal, timeIntnternal2, benchmark,
        benchmark2 foodCount, bulletsCount, bulletsPresent, foodPresent, proceed
     * time is used to track the time as the game goes
     * timeInternal is the same however it can be reset as it is a behind the scenes timer, one to be used for changing conditions etc
     * timeInternal2 is the same as timeInternal but used for ammo
     * benchmark is the benchmark for how long the program should wait before adding a new object of a krabby patty
     * benchmark2 is the benchmark for how long the program should wait before adding a new object of Ammo
     * foodCount counts the amount of krabby patties the diver has collected
     * bulletsCount counts the amount of bullets (objects of ammo) the diver has collected
     * foodPresent checks if a krabby patty object exists or not, to avoid more than one on the screen at the same time
     * bulletsPresent checks if an ammo object exists or not, to avoid more than one one the screen at the same time
     * proceed controls the progression to the next level - only becomes true when enough ammo is collected
     * when it's true, the player can access the next level
     */

    int time = 0;
    int timeInternal = 0;
    int timeInternal2 = 0;
    int benchmark =10;
    int benchmark2 = 20;
    int foodCount = 0;
    int bulletsCount = 0;
    boolean foodPresent = false;
    boolean bulletsPresent = false;
    boolean proceed = false;
    
    /*intiialsing a diver variable of the diver class, to add in later
     * initialising a healthBar variable of the healthBar class to add in later
     * initialising a food variable of the KrabbyPatty class to add in later
     * initialising a bullet variable of the Ammo class to add in later
     * initialising a shield variable of the Shield class to add in later
     */

    Diver diver = new Diver();
    HealthBar healthBar = new HealthBar(this);
    KrabbyPatty food = new KrabbyPatty();
    Ammo bullets = new Ammo();
    Shield shield = new Shield(this);
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level1()
    {
        
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        //setting the speed faster than usual as it's too slow with the normal speed
        Greenfoot.setSpeed(60);
        //populating the world 
        populate();
        
        
        

        
    }
    /* populate method populates the world
     * adds a diver, health bar and seaweed and shipwrecked wood objects
     * iterates through and adds a seperate instance of the seaweed and shipwreck objects until it 
     * meets the requirement of how many objects of each class should be on screen at a time 
     * (clarified through the FINAL variables at the beginning of the class)
     */
    public void populate(){

        addObject(diver, 500 ,556);
        addObject(healthBar, diver.getX() - 5, diver.getY() - 50);

        for (int i = 0; i < NUMBER_OF_SHIPWRECK; i++){
            int x = Greenfoot.getRandomNumber(getWidth());
            addObject(new ShipwreckWood(), x, 4);
        }

        for (int count = 0; count < NUMBER_OF_SEAWEED; count++){
            int randomX = Greenfoot.getRandomNumber(getWidth());
            int randomY = (Greenfoot.getRandomNumber(99) + 500);
            addObject(new Seaweed(), randomX, randomY);
        }

    }

    /* As the act method just keeps looping, it has been implemented for the creation of the krabby patties as this needs to be an iteratve action
     * time, timeInternal and timeInternal2 are incremented here as their incrementation needs to happen consistently
     * the method checkNextLevel is called here as that function needs to be an iterative action
     * the act method is largely used for shield, krabby patty and ammo interactions with the world.
     */

    public void act() {
        time++;
        timeInternal++;
        timeInternal2++;
        checkNextLevel();
        addRemoveKrabbyPatty();
        collisionCheck();
        shieldAdder();
        shieldRemover();
        addRemoveAmmo();
        collisionCheckAmmo();
        ammoChecker();

        //inserting the pause functionality
        while(Greenfoot.isKeyDown("P"))
        {
            Greenfoot.delay(1);
        }

    }

    /* this method checks if enough time has passed to either remove or add a krabby patty.
        * first it checks if there is already a krabby patty existing, in which case it removes it and resets the internal timer, benchmark and the foodPresent status
        * if there isn't, it adds a krabby patty object somewhere randomly in the world and sets the benchmark, interal timer and foodPresent variables to their orginal state.
    */

    public void addRemoveKrabbyPatty(){
        
        if (timeInternal/ 60 >= benchmark) {
            if (foodPresent) {
                removeObject(food);
                benchmark = 5; // Wait for 5 seconds next time
                timeInternal = 0;
                foodPresent = false;
            } else {
                int randx = Greenfoot.getRandomNumber(getWidth());
                int randy = Greenfoot.getRandomNumber(getHeight());
                food = new KrabbyPatty();
                addObject(food, randx, randy);
                foodPresent = true;
                benchmark = 30; // Wait for 30 seconds next time
                timeInternal =0;
            }
        }
    }
    /* this method first checks if there is an existing krabby patty object in the world before continuing with the statement as sometimes greenfoot
         * would have problems when running the nested if statement (it wasn't previously nested)
         * once it is confirmed that krabby patty object exists, it then uses the KrabbyPatty method to check if the diver has collided with it and if so increments
         * foodCount and resets the benchmark and outcome variables
    */
    public void collisionCheck () {

        if (food!= null && foodPresent) {
            if (food.checkCollision()){
                benchmark = 1;
                foodCount++;
                food.outcome = false;
            }
            
        }
    }
    /* this method initialises the shield once the foodCount is 5 (>= used for safeguarding)
         * the internal timer is reset again and the shield is spawned on top of the diver
         * the shield follows the rotation of the diver so as to not look weird when flipped
         * any remaining KrabbyPatty objects are removed, the foodPresent status set to false and foodCount is set to 0
         * the benchmark is set high so that it doesn't accidentally spawn in any krabby patties
    */

    public void shieldAdder(){

        if (foodCount >= 5) {
            timeInternal = 0;
            shield.setLocation(diver.getX()- 101, diver.getY() - 43);
            addObject(shield, diver.getX() - 101, diver.getY() - 43);
            shield.setRotation(diver.getRotation());
            if (shield.getRotation() > 180) {
                shield.setLocation(diver.getX() -38, diver.getY() +100);
            }
            else if (shield.getRotation() > 90){
                shield.setLocation(diver.getX() + 100, diver.getY() + 38);
            }
            else if (shield.getRotation() > 0) {
                shield.setLocation(diver.getX() +43, diver.getY()-101);
            }
            removeObject(food);
            foodPresent = false;
            benchmark = 10000;
            foodCount = 0; 
        }
    }

    /* once again the prerequiste for the statement is checking if the shield actually exists.
        * uses the Shield variables checker to check if the duration of the shield is over yet
        * if true, it resets the KrabbyPatty outcome variable to false as there wouldn't have been a chance for it to reset before the shield
        * benchmark and internal timer is reset
        * finally, the shield object is removed
        * the healthbar interaction is reset: the diver can lose health now and the cool down is back to normal
        * sets the Shield variable checker to false to not trigger the statement unnecessarily.
    */
    public void shieldRemover(){

        if (shield!= null) {
            if (shield.checker){
                food.outcome = false;
                benchmark = 30; // Wait for 30 seconds next time
                timeInternal =0;
                removeObject(shield);
                healthBar.canLoseHealth = true;
                healthBar.cooldown = 30;
                shield.checker = false;
                
            }
        }
    }

    /* this method checks if enough time has passed to either remove or add an ammo object.
        * first it checks if there is already an ammo object existing, in which case it removes it and resets the internal timer, benchmark and the bulletPresent status
        * if there isn't, it adds an ammo object somewhere randomly in the world and sets the benchmark, interal timer and bulletPresent variables to their original state.
    */
    public void addRemoveAmmo(){
        if (timeInternal2/ 60 >= benchmark2) {
            if (bulletsPresent) {
                removeObject(bullets);
                benchmark2 = 20;
                timeInternal2 = 0;
                bulletsPresent = false;
            } else {
                int randx2 = Greenfoot.getRandomNumber(getWidth());
                int randy2 = Greenfoot.getRandomNumber(getHeight());
                addObject(bullets, randx2, randy2);
                bullets.checkAmmoCollision();
                bulletsPresent = true;
                benchmark2 = 30;
                timeInternal2 =0;
            }
        }
    }
    /* this method first checks if there is an existing ammo object in the world before continuing with the statement as sometimes greenfoot
    * would have problems when running the nested if statement (it wasn't previously nested)
    * once it is confirmed that the ammo object exists, it then uses the Ammo method to check if the diver has collided with it and if so increments
    * bulletCount and resets the benchmark and outcome variables
    * once the player has collected at least one ammo object, it will show on screen how many objects they've collected
    */

    public void collisionCheckAmmo(){
        if (bullets!= null && bulletsPresent) {
            if (bullets.checkAmmoCollision()){
                bullets.checker = false;
                bulletsCount = bulletsCount +1;
                showText("Ammo collected: " + bulletsCount,120,36);
                benchmark2 = 5;
            }
            
        }
    }
    /*this method checks if the player has collected enough bullets
     * if they have collected 7, the time is reset to 0
     * the bullet object is removed
     * the benchmark is set high so that the above methods aren't triggered and cause ammo to spawn
     * after the user has collected all that they need
     * sets the proceed variable to true - this will be used in checkNextLevel()
     */
    public void ammoChecker(){
        if (bulletsCount == 7) {
            timeInternal2 = 0;
            removeObject(bullets);
            bulletsPresent = false;
            benchmark2 = 100000;
            proceed = true;
        }
    }
    /*once the time provided for level is up, the player beats level 1 and gets a message on screen
     * if proceed is true (if the player has collected enough ammo) they can continue to level 2, shown by a message on screen
     * if it isn't true, the player gets two message, one telling them they didn't have enough ammo, another telling them they should try again.
     */
    public void checkNextLevel() {
        if (time/60 == 280 || time/60 >= 280){
            showText("Success! You beat Level 1! ", getWidth()/2 ,getHeight()/2);
            if (proceed) {
                showText("Amazing, you have collected enough ammo. You can move onto the next level!", getWidth()/2 , getHeight()/2 - 20);
                showText("Click anywhere to move onto the next level", getWidth()/2 , getHeight()/2 + 20);
                Greenfoot.delay(600);
                    Greenfoot.setWorld(new Level2Objects());
                
            } else {
                showText("Unfortunately, you have not collected enough ammo to move onto the next level.", getWidth()/2 , getHeight()/2 + 20);
                showText("Try again next time :(",getWidth()/2 , getHeight()/2 + 40);
            }
            Greenfoot.stop();
        }
    }
    /* getter method for the current diver object */
    public Diver getDiver(){
        return diver;
    }
    /*gettter method for the current health bar object */
    public HealthBar getHealthBar() {
        return healthBar;
    }
    /*getter method for the current krabbypatty object */
    public KrabbyPatty getKrabbyPatty() {
        return food;
    }

}
