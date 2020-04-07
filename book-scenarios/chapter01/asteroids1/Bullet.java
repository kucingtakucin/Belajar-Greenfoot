import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A bullet that can hit asteroids.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 2.0
 */
public class Bullet extends Mover{
    private int size;
    private GreenfootImage bullet = new GreenfootImage("bullet.png");
    
    /** A bullet looses one life each act, and will disappear when life = 0 */
    private int life = 30;
    
    /** The damage this bullet will deal */
    private int damage = 16;
    
    public Bullet(){
        setSize(100);
    }
    
    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        increaseSpeed(new Vector(rotation, 15));
        Greenfoot.playSound("EnergyGun.wav");
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setSize(int size){
        // put your code here
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size, size);
    }

    
    /**
     * The bullet will damage asteroids if it hits them.
     */
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            move();
            Asteroid asteroid = (Asteroid) getOneIntersectingObject(Asteroid.class);
            if (asteroid != null) {
                getWorld().removeObject(this);
                asteroid.hit(damage);
            }
            else {
                life--;
            }
        }
    }
}