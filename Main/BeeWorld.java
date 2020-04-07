import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Adam Arthur Faizal) 
 * @version (26 Maret 2020)
 */
public class BeeWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
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
        Fly fly = new Fly();
        addObject(fly,98,114);
        Fly fly2 = new Fly();
        addObject(fly2,320,107);
        Fly fly3 = new Fly();
        addObject(fly3,544,114);
        Fly fly4 = new Fly();
        addObject(fly4,209,322);
        Fly fly5 = new Fly();
        addObject(fly5,447,319);
    }
}
