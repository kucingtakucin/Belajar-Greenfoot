import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ini adalah class Fly.
 *
 * @author (Adam Arthur Faizal) 
 * @version (12 April 2020)
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
        gerak(this.SPEED);
        handleTepi();
    }
}
