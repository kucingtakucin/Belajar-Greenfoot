import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ini adalah kelas Mover.
 * 
 * @author (Adam Arthur Faizal) 
 * @version (Rabu, 15 April 2020)
 */
public abstract class Mover extends Actor
{  
    private final int RIGHT = 5;
    private final int LEFT = -5;
    /**
     * Act - do whatever the mover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public abstract void act(); 

    public void movement() {
        if (Greenfoot.isKeyDown("right")){
            this.move(this.RIGHT);
        } else if (Greenfoot.isKeyDown("left")){   
            this.move(this.LEFT);
        } else if (Greenfoot.isKeyDown("up")){
            this.setLocation(this.getX(), this.getY() - 5);
        } else if(Greenfoot.isKeyDown("down")){
            this.setLocation(this.getX(), this.getY() + 5);   
        }
    }
}
