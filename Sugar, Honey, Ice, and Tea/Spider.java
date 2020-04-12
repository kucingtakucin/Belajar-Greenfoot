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
        gerak(this.SPEED);
    }
}
