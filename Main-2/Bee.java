import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (Adam Arthur Faizal) 
 * @version (a version number or a date)
 */
public class Bee extends Actor
{
    private int scores;
    private int lives = 3;
    
    public Bee(){
        setRotation(Greenfoot.getRandomNumber(359));
        scores = 0;
    }
    
    /**
     * Act - Method ini akan membuat bee berjalan dengan kecepatan 4 satuan kecepatan, dan akan berbelok secara random serta akan
     * berbalik arah sebesar 270 derajat jika sudah mencapai pembatas dari world
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        jalan(8);
        handleMovement();
        eatFly();
        atTepi();
        caughtBySpider();
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
        if(fly != null){
            getWorld().removeObject(fly);
            updateScore();
            Greenfoot.playSound("slurp.wav");
            getWorld().addObject(fly, Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
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
    public boolean caughtBySpider()
    {
        if (isTouching(Spider.class)){
            this.setLocation(30,30);
            tampilkanLives();
            if (lives <= 0){
                Greenfoot.stop();
            } 
        }
        return true;
    }

    /**
     * updateScore - Menampilkan scores ke layar
     */
    public void updateScore()
    {
        scores++;
        getWorld().showText("Score : " + scores, 60, 480);
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
