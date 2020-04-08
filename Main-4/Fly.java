import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fly here.
 *
 * @author (Adam Arthur Faizal) 
 * @version (7 April 2020)
 */
public class Fly extends Movement
{
    private final int SPEED = 8;
    /**
     * Constructor for objects of class Fly
     */
    public Fly(int direction)
    {
       setRotation(direction);
    }

    /**
     * Act - do whatever the Movement wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act(){
        gerak(SPEED);
        handleTepi();
    }
}
