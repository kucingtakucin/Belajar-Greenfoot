import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spider here.
 * 
 * @author (Adam Arthur Faizal) 
 * @version (7 April 2020)
 */
public class Spider extends Movement
{
    private final int SPEED = 5;
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
        gerak(SPEED);
    }
}
