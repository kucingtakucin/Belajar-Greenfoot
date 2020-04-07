import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 2.0
 */
public class Rocket extends Mover
{
    private int gunReloadTime;         // The minimum delay between firing the gun.
    private int reloadDelayCount;      // How long ago we fired the gun the last time.
    private Vector acceleration;       // A vector used to accelerate when using booster.
    private int shotsFired;            // Number of shots fired.
    private int size;
    
    private GreenfootImage rocket = new GreenfootImage("rocket.png");
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");

    /**
     * Initialise this rocket.
     */
    public Rocket(){
        setSize(75);
        gunReloadTime = 20;
        reloadDelayCount = 0;
        acceleration = new Vector(0, 0.05);    // used to accelerate when thrust is on
        increaseSpeed(new Vector(Greenfoot.getRandomNumber(360), 0.2));   // initially slowly drifting
        shotsFired = 0;
        
    }
    
    public void setSize(int size) {
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size, size);
    }
    
    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act(){
        move();
        checkKeys();
        checkCollision();
        reloadDelayCount++;
    }
    
    public void move(){
        x = x + movement.getX();
        y = y + movement.getY();
        if(x >= getWorld().getWidth()) {
            x = getWorld().getWidth() - 1;
        } else if(x <= 0) {
            x = movement.getX();
        } else if(y >= getWorld().getHeight()) {
            y = getWorld().getHeight() - 1;
        } else if(y <= 0) {
            y = movement.getY();
        }
        setLocation(x, y);
        increaseSpeed(new Vector(0, 0));
    }
    
    /**
     * Return the number of shots fired from this rocket.
     */
    public int getShotsFired(){
        return shotsFired;
    }
    
    /**
     * Set the time needed for re-loading the rocket's gun. The shorter this time is,
     * the faster the rocket can fire. The (initial) standard time is 20.
     */
    public void setGunReloadTime(int reloadTime){
        gunReloadTime = reloadTime;
    }
    
    /**
     * Check whether we are colliding with an asteroid.
     */
    private void checkCollision() {
        Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
        if (asteroid != null) {
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys(){
        ignite(Greenfoot.isKeyDown("up"));
        if(Greenfoot.isKeyDown("left")) {
            turn(-3);
        } else if(Greenfoot.isKeyDown("right")) {
            turn(3);
        } else if(Greenfoot.isKeyDown("space")) {
            fire();
        } 
        // else {
            // brakeback(Greenfoot.isKeyDown("down"));
        // }
    }
    
    /**
     * Should the rocket be ignited?
     */
    private void ngegas(){
        setImage(rocketWithThrust);
        setSize(75);
        acceleration.setDirection(getRotation());
        increaseSpeed(acceleration);
    }
    
    private void ignite(boolean boosterOn) {
        if (boosterOn) {
            ngegas();
        } else {
            setImage(rocket);
            setSize(75);
        }
    }
    
    private void brakeback(boolean isBrake){
        if(isBrake) {
            ngegas();
        } else {
            setImage(rocket);
            setSize(75);
        }
    }
    
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() {
        if (reloadDelayCount >= gunReloadTime) {
            Bullet b = new Bullet(getMovement().copy(), getRotation());
            getWorld().addObject(b, getX(), getY());
            b.move();
            shotsFired++;
            reloadDelayCount = 0;   // time since last shot fired
        }
    }
}