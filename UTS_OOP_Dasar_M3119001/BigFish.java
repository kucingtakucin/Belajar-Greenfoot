import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ini adalah kelas BigFish
 * 
 * @author (Adam Arthur Faizal) 
 * @version (Rabu, 15 April 2020)
 */
public class BigFish extends Mover
{
    private int x, y;
    /**
     * Act - do whatever the bigfish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
        movement();
        arahIkan();
        eatKudaLaut();        
    }    

    public void arahIkan() {
        if(Greenfoot.isKeyDown("right")){
            this.setImage("bigfish.png");
        }
        else if(Greenfoot.isKeyDown("left")){
            this.setImage("bigfish2.png");
        }

    }

    public void eatKudaLaut() {
        KudaLaut kudaLaut = (KudaLaut) getOneIntersectingObject(KudaLaut.class);
        BackWorld backWorld = (BackWorld)getWorld();
        if(kudaLaut != null){
            getWorld().removeObject(kudaLaut);
            Greenfoot.playSound("slurp.wav");
            backWorld.updateScore();
            this.x = Greenfoot.getRandomNumber(getWorld().getWidth());
            this.y = Greenfoot.getRandomNumber(getWorld().getHeight());
            getWorld().addObject(kudaLaut, x, y);
        }
    }

}