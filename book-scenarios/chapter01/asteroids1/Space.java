import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Space. Something for rockets to fly in...
 * 
 * @author Michael Kölling
 * @version 2.1
 */
public class Space extends World
{
    /**
     * Create the space world with black background and stars.
     * Membuat dunia luar angkasa dengan backgound berwarna hitam dan bintang-bintang
     */
    public Space(){
        super(800, 600, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        createStars(5000);
        Explosion.initialiseImages();
    }
    
    /**
     * Create some random stars in the world
     * Membuat beberapa bintang secara random di dunia luar angkasa
     */
    private void createStars(int number) 
    {
        GreenfootImage background = getBackground();             
        for (int i=0; i < number; i++) {            
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            int color = 150 - Greenfoot.getRandomNumber(120);
            background.setColorAt(x, y, new Color(color,color,color));
        }
    }
}