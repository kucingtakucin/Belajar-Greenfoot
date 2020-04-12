import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ini adalah class Spider.
 * 
 * @author (Adam Arthur Faizal) 
 * @version (12 April 2020)
 */
public class Spider extends Movement
{
    private final int SPEED = 4;
    /**
     * Constructor for objects of class Spider
     */
    public Spider(int direction)
    {
        setRotation(direction);
    }

    /**
     * Act - do whatever the Movement wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act(){
        handleTepi();
        smartMovement();
    }
    
    /**
     * smartMovement - Kelas Spider akan selalu mengikuti kelas Bee
     */
    public void smartMovement()
    {
        this.move(this.SPEED);
        BeeWorld beeWorld = (BeeWorld)getWorld();
        Bee bee = beeWorld.getBee();
        this.turnTowards(bee.getX(), bee.getY());
    }

}
