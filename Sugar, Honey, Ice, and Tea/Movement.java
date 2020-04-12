import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ini adalah class untuk mengatur pergerakan dari object.
 * 
 * @author (Adam Arthur Faizal) 
 * @version (12 April 2020)
 */
public abstract class Movement extends Actor
{
    
    /**
     * Act - do whatever the Movement wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    abstract public void act();
    
    /**
     * gerak - Method untuk menggerakkan object
     */
    public void gerak(int speed)
    {
        this.move(speed);
        if (Greenfoot.getRandomNumber(100) < 30){
            this.turn(Greenfoot.getRandomNumber(46) - 23);
        }
    }
     
    /**
     * handleTepi - Method untuk membuat object berbalik 180 derajat ketika mencapai edge of the world
     */
    public void handleTepi()
    {
        if (isAtEdge()){
            this.turn(90);
        }
    }
}
