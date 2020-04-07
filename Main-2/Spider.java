import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spider extends Actor
{
    /**
     * An example of a method - replace this comment with your own
     */
    public Spider()
    {
        setRotation(Greenfoot.getRandomNumber(359));
    }

    /**
     * Act - do whatever the Spider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        gerak();
        handleTepi();
    }    

    /**
     * gerak - Untuk membuat kelas Spider bergerak maju dan berbelok
     */
    public void gerak()
    {
        move(6);
        if (Greenfoot.getRandomNumber(100) < 50){
            turn(Greenfoot.getRandomNumber(20) - 10);
        }
    }

    /**
     * handleTepi - Untuk membuat kelas Spider berbalik 180 derajat ketika mencapai edge of the world
     */
    public void handleTepi()
    {
        if (isAtEdge()){
            turn(180);
            getWorld().addObject(new Spider(), Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
            getWorld().addObject(new Spider(), Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
        }
    }

}
