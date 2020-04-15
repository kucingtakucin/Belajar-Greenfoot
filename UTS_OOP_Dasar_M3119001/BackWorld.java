import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ini adalah kelas BackWorld
 * 
 * @author (Adam Arthur Faizal) 
 * @version (Rabu, 15 April 2020)
 */
public class BackWorld extends World
{
    public int score = 0;
    public LittleFish littleFish = new LittleFish();
    /**
     * Constructor for objects of class BackWorld.
     * 
     */
    public BackWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 400, 1); 
        prepare();
    }

    public void updateScore(){
        this.score++;
        showText("SCORE : " + score, 350, 20);
    }

    public void prepare(){
        for (int i = 0; i < 5; i++){ 
            addObject(new KudaLaut(), 5, Greenfoot.getRandomNumber(380));
            addObject(new KudaLaut(), 680 ,Greenfoot.getRandomNumber(380));
        }
        addObject(littleFish, 350, 200);
    }
    
    public LittleFish getLittleFish(){
        return this.littleFish;
    }
}
