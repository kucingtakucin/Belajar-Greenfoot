import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KupuKupu here.
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly extends Actor
{
    /**
     * An example of a method - replace this comment with your own
     *
     */
    public Fly()
    {
       setRotation(Greenfoot.getRandomNumber(359));
    }

    /**
     * Act - do whatever the KupuKupu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        jalan(8);
        gerakAcak();
        adaPembatas();
    }  

    /**
     * An example of a method - replace this comment with your own
     * @param  x  a sample parameter for a metho
     */
    public void jalan(int x)
    {
        move(x);
    }

    /**
     * An example of a method - replace this comment with your own
     */
    public void gerakAcak()
    {
        if(Greenfoot.getRandomNumber(100) < 30){
            turn(Greenfoot.getRandomNumber(30) - 15);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     */
    public void adaPembatas()
    {
        if(isAtEdge()){
            turn(45);
        }
    }
}
