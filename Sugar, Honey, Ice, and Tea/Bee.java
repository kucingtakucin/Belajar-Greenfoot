        import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ini adalah class Bee.
 * 
 * @author (Adam Arthur Faizal) 
 * @version (12 April 2020)
 */
public class Bee extends Movement
{
    private int scores, x, y;
    private int lives = 3;
    private int currentImages = 0;
    private final int SPEED = 8;
    private GreenfootImage[] images = new GreenfootImage[3];
    
    /**
     * Constructor for objects of class Fly
     */
    public Bee(){
        this.scores = 0;
    }
    
    @Override
    public void act(){
        eatFly();
        atTepi();
        caughtBySpider();
        handleMovement(SPEED);
        loopingArrays();
        animateBee();
        showTimer();
    }   

    /**
     * handleMovement - Untuk mengambil event dari keyboard
     * 
     * @param  speed  Parameter untuk mengatur kecepatan
     */
    public void handleMovement(int speed)
    {
        this.move(speed);
        if(Greenfoot.isKeyDown("right")){
            this.turn(5);
        }
        if(Greenfoot.isKeyDown("left")){
            this.turn(-5);
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
            this.x = Greenfoot.getRandomNumber(getWorld().getWidth());
            this.y = Greenfoot.getRandomNumber(getWorld().getHeight());
            getWorld().addObject(fly, x, y);
        }
    }

    /**
     * atTepi - Untuk membuat kelas Bee menembus edge of the world  
     */
    public void atTepi()
    {
        if(getX() >= getWorld().getWidth() - 1){
            this.setLocation(0,getY());
        }
        if(getY() >= getWorld().getHeight() - 1){
            this.setLocation(getX(),0);
        }
        if(getX() == 0){
            this.setLocation(getWorld().getWidth(),getY());
        }
        if(getY() == 0){
            this.setLocation(getX(), getWorld().getHeight());
        }
    }
    
    /**
     * caughtBySpider - Untuk membuat kelas Bee dimakan oleh kelas Spider
     */
    public void caughtBySpider()
    {
        Spider spider = (Spider) getOneIntersectingObject(Spider.class);
        if (spider != null){
            Greenfoot.playSound("au.wav");
            this.setLocation(30,30);
            tampilkanLives();
            if (lives <= 0){
                BeeWorld beeWorld = (BeeWorld) getWorld();
                beeWorld.gameOver();
            } 
        }
    } 

    /**
     * tampilkanLives - Menampilkan lives ke layar
     */
    public void tampilkanLives()
    {
        this.lives--;
        getWorld().showText("Live : " + lives, 650, 480);
    }

    /**
     * loopingArrays - Melakukan looping pada array images
     */
    public void loopingArrays()
    {
        for (int i = 0; i < this.images.length; i++){
            this.images[i] = new GreenfootImage("bee" + i + ".png");
        }
    }
    
    /**
     * animateBee - Membuat kelas Bee seakan-akan bergerak secara dinamis
     */
    public void animateBee()
    {
        if (this.currentImages == this.images.length){
            this.currentImages = 0;
            return;
        }
        setImage(this.images[this.currentImages]);
        this.currentImages++;
    }

    /**
     * showTimer - Menampilkan timer di layar
     */
    public void showTimer()
    {
        BeeWorld beeWorld = (BeeWorld) getWorld();
        beeWorld.showTimer();
    }

}
