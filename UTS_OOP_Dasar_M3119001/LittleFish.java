import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ini adalah kelas LittleFish
 * 
 * @author (Adam Arthur Faizal) 
 * @version (Rabu, 15 April 2020)
 */
public class LittleFish extends Mover
{ 
    private int x, y;
    /**
     * Act - do whatever the littlefish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
        movement();
        arahIkan();
        eatKudaLaut();
        jadiBigFish();  
    }    

    public void arahIkan() {
        if(Greenfoot.isKeyDown("right")){
            this.setImage("fish.png");
        }
        else if(Greenfoot.isKeyDown("left")){
            this.setImage("fish2.png");
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

    public void jadiBigFish(){
        BackWorld backWorld = (BackWorld)getWorld();
        LittleFish littleFish = backWorld.getLittleFish();
        if (backWorld.score >= 10){
            backWorld.addObject(new BigFish(), littleFish.getX(), littleFish.getY());
            Greenfoot.playSound("fanfare.wav");
            backWorld.removeObject(littleFish);
        }
    }
}