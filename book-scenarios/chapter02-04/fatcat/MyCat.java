import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MyCat is your own cat. Get it to do things by writing code in its act method.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyCat extends Cat
{
    /**
     * Act - do whatever the MyCat wants to do.
     */
    public void act(){
        jalan();
    }
    
    public void jalan(){
        if(Greenfoot.isKeyDown("right")){
            walkRight(1);
        } else if(Greenfoot.isKeyDown("left")){
            walkLeft(1);
        }
    }
}
