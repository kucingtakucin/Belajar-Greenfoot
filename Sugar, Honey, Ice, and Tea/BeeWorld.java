import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ini adalah dunia Bee
 * 
 * @author (Adam Arthur Faizal) 
 * @version (12 April 2020)
 */
public class BeeWorld extends World
{
    private int scores = 0, direction, speed, x, y, a, b;
    private long detik;
    private Bee bee = new Bee();
    public SimpleTimer timer = new SimpleTimer();
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public BeeWorld(){    
        // Create a new world with 700x500 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(bee, 30, 30);
        for (int i = 0; i < 10; i++){
            this.direction = Greenfoot.getRandomNumber(360);
            this.speed = Greenfoot.getRandomNumber(5) + 5;
            this.x = Greenfoot.getRandomNumber(this.getWidth());
            this.y = Greenfoot.getRandomNumber(this.getHeight());
            addObject(new Fly(speed), x, y);
            if (i < 3){
                this.a = Greenfoot.getRandomNumber(this.getWidth());
                this.b = Greenfoot.getRandomNumber(this.getHeight());
                addObject(new Spider(direction), a, b);
            }
        }
    }
    
    /**
     * getBee - Mendapatkan informasi dari kelas bee
     */
    public Bee getBee()
    {
        return this.bee;
    }

    /**
     * showTimer - Menampilkan timer dilayar
     */
    public void showTimer()
    {
        this.detik = timer.mark();
        showText("Timer : " + this.detik, 350, 480);
    }
    
    /**
     * updateScore - Method untuk memperbarui nilai score ketika kelas Bee memakan kelas Fly
     */
    public void updateScore()
    {
        this.scores++;
        showText("Score : " + scores, 60, 480);
        if (this.scores == 50){
            gameFinish();
        }
    }
    
    /**
     * gameOver - Menampilkan ScoreBoard ketika game over
     */
    public void gameOver()
    {
        addObject(new ScoreBoard("Game Over ",this.scores), getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }

    /**
     * gameFinish - Menampilkan ScoreBoard ketika memenangkan game
     */
    public void gameFinish()
    {
        addObject(new ScoreBoard("Selamat, kamu menang!", this.scores), getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }

}
