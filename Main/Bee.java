import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (Adam Arthur Faizal) 
 * @version (a version number or a date)
 */
public class Bee extends Actor
{
    /**
     * Act - Method ini akan membuat bee berjalan dengan kecepatan 4 satuan kecepatan, dan akan berbelok secara random serta akan
     * berbalik arah sebesar 270 derajat jika sudah mencapai pembatas dari world
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        jalan(6);
        handleMovement();
        eatFly();
        atTepi();
    }

    /**
     * @param  angka  a sample parameter for a method */
    public void jalan(int angka)
    {
        move(angka);
    }

    /**
     * @param  angka  a sample parameter for a method */
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
     * An example of a method - replace this comment with your own
     *
     */
    public void eatFly()
    {
        Fly fly = (Fly) getOneIntersectingObject(Fly.class);
        if(fly != null){
            getWorld().removeObject(fly);
            getWorld().addObject(fly,Greenfoot.getRandomNumber(700),Greenfoot.getRandomNumber(500));
            fly.setRotation(360);
        }
    }

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
}
