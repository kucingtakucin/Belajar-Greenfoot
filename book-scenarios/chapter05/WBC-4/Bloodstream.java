import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bloodstream is the setting for our White Blood Cell scenario. It's a place
 * where blood cells, bacteria and viruses float around.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Bloodstream extends World
{
    private int score;
    private int time;
    
    /**
     * Constructor: Set up the starting objects.
     */
    public Bloodstream()
    {    
        super(780, 360, 1); 
        setPaintOrder(Border.class);
        prepare();
        score = 0;
        time = 2000;
        showScore();
        showTime();
    }

    /**
     * Create new floating objects at irregular intervals.
     */
    public void act()
    {
        if (Greenfoot.getRandomNumber(100) < 3)
        {
            addObject(new Bacteria(), 779, Greenfoot.getRandomNumber(360));
        }
        
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Lining(), 779, 0);
        }
        
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Lining(), 779, 359);
        }
        
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Virus(), 779, Greenfoot.getRandomNumber(360));
        }
        
        if (Greenfoot.getRandomNumber(100) < 6)
        {
            addObject(new RedCell(), 779, Greenfoot.getRandomNumber(360));
        }
        countTime();
    }
    
    /**
     * Add some points to our current score. (May be negative.)
     * If the score falls below 0, game's up.
     */
    public void addScore(int points)
    {
        score = score + points;
        showScore();
        if (score < 0) 
        {
            Greenfoot.playSound("game-over.wav");
            Greenfoot.stop();
        }
    }
    
    /**
     * Show our current score on screen.
     */
    private void showScore()
    {
        showText("Score: " + score, 80, 25);
    }

    /**
     * Count down the game time and display it. Stop the game 
     * with a winning message when time is up.
     */
    private void countTime()
    {
        time--;
        showTime();
        if (time == 0)
        {
            showEndMessage();
            Greenfoot.stop();
        }
    }

    /**
     * Show the remaining game time on screen.
     */
    private void showTime()
    {
        showText("Time: " + time, 700, 25);
    }
    
    /**
     * Show the end-of-game message on screen.
     */
    private void showEndMessage()
    {
        showText("Time is up - you win!", 390, 150);
        showText("Your final score: " + score + " points", 390, 170);
    }
    
    /**
     * Prepare the world for the start of the program. In this case: Create
     * a white blood cell and the lining at the edge of the blood stream.
     */
    private void prepare()
    {
        WhiteCell whitecell = new WhiteCell();
        addObject(whitecell, 128, 179);
        
        Lining lining = new Lining();
        addObject(lining, 126, 1);
        Lining lining2 = new Lining();
        addObject(lining2, 342, 5);
        Lining lining3 = new Lining();
        addObject(lining3, 589, 2);
        Lining lining4 = new Lining();
        addObject(lining4, 695, 5);
        Lining lining5 = new Lining();
        addObject(lining5, 114, 359);
        Lining lining6 = new Lining();
        addObject(lining6, 295, 353);
        Lining lining7 = new Lining();
        addObject(lining7, 480, 358);
        Lining lining8 = new Lining();
        addObject(lining8, 596, 359);
        Lining lining9 = new Lining();
        addObject(lining9, 740, 354);
        
        Border border = new Border();
        addObject(border, 0, 180);
        Border border2 = new Border();
        addObject(border2, 770, 180);
    }
}
