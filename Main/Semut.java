import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Semut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Semut extends Actor{
    private int x;
    private int y;
    
    Semut(){
        act();
    }
    
    /**
     * Act - do whatever the Semut wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveForward();
        turnRight();
    }
    
    public void turnRight(){
        turn(90);
    }
    
    public void moveForward(){
        move(1);
    }
}
