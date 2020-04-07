import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (Adam Arthur Faizal) 
 * @version (7 April 2020)
 */
public class Bee extends Movement
{
    private int scores;
    private int lives = 3;
    
    /**
     * Constructor for objects of class Fly
     */
    public Bee(int direction){
        setRotation(direction);
        scores = 0;
    }
    
    @Override
    public void act(){
        jalan(6);
        eatFly();
        atTepi();
        caughtBySpider();
        handleMovement();
    }
    
    /**
     * jalan - Untuk membuat Bee berjalan maju */
    public void jalan(int angka)
    {
        move(angka);
    }

    /**
     * handleMovement - Untuk mengambil event dari keyboard */
    public void handleMovement()
    {
        if(Greenfoot.isKeyDown("right")){
            turn(5);
        }
        if(Greenfoot.isKeyDown("left")){
            turn(-5);
        }
    }

    /**
     * eatFly() - Untuk membuat kelas Bee bisa memakan kelas Fly
     */
    public void eatFly()
    {
        Fly fly = (Fly) getOneIntersectingObject(Fly.class);
        BeeWorld beeworld = (BeeWorld)getWorld();
        if(fly != null){
            getWorld().removeObject(fly);
            Greenfoot.playSound("slurp.wav");
            beeworld.updateScore();
            int x = Greenfoot.getRandomNumber(getWorld().getWidth());
            int y = Greenfoot.getRandomNumber(getWorld().getHeight());
            getWorld().addObject(fly, x, y);
        }
    }

    /**
     * atTepi - Untuk membuat kelas Bee menembus edge of the world  
     */
    public void atTepi()
    {
        if(getX() >= getWorld().getWidth()){
            setLocation(0,getY());
        }
        if(getY() >= getWorld().getHeight()){
            setLocation(getX(),0);
        }
        if(getX() == 0){
            setLocation(getWorld().getWidth(),getY());
        }
        if(getY() == 0){
            setLocation(getX(), getWorld().getHeight());
        }
    }
    
    /**
     * caughtBySpider - Untuk membuat kelas Bee dimakan oleh kelas Spider
     */
    public void caughtBySpider()
    {
        if (isTouching(Spider.class)){
            this.setLocation(30,30);
            tampilkanLives();
            if (lives <= 0){
                Greenfoot.stop();
            } 
        }
    } 

    /**
     * tampilkanLives - Menampilkan lives ke layar
     */
    public void tampilkanLives()
    {
        lives--;
        getWorld().showText("Live : " + lives, 650, 480);
    }

}
