import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ini adalah kelas KudaLaut
 * 
 * @author (Adam Arthur Faizal) 
 * @version (Rabu, 15 April 2020)
 */
public class KudaLaut extends Actor
{     
    private GreenfootImage image1 = new GreenfootImage("seahorse.png");
    private GreenfootImage image2 = new GreenfootImage("seahorse2.png");
    private final int RIGHT = 4;
    private final int LEFT = -4;
    /**
     * Act - do whatever the kudalaut wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        gerakAcak();
        arahKuda();
        turnAtEdge();
    }

    public void arahKuda(){
        if(this.getX() == 5){
            this.setImage(image1);
        }

        if(this.getX() >= 680) {
            this.setImage(image2);
        }
    }

    public void gerakAcak(){
        if(getImage() == image1){
            this.move(this.RIGHT);
        }
        
        if (getImage() == image2){
            this.move(this.LEFT);
        }
        
        if(Greenfoot.getRandomNumber(100) < 10){
            this.turn(Greenfoot.getRandomNumber(20) - 40);
        }
    }
    
    public void turnAtEdge(){
        if(isAtEdge()){
            this.turn(45);
        }
    }
}
