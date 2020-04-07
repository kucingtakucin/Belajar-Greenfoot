import greenfoot.*;
import java.awt.font.FontRenderContext;
import java.awt.Graphics2D;

/**
 * A switch with a graphical display that can be switched on and off.
 * @version 1.1
 */
public class Switch extends Actor
{
    private boolean up = true;
    
    private GreenfootImage upImage = new GreenfootImage("switch-up.png");
    private GreenfootImage downImage = new GreenfootImage("switch-down.png");

    public Switch(String text1, String text2)
    {
        write(upImage, text1, text2);
        write(downImage, text1, text2);
        setImage(upImage);
    }
    
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            toggle();
        }
    }
    
    public boolean isOn()
    {
        return !up;
    }
    
    public void toggle()
    {
        up = !up;
        if (up) {
            setImage(upImage);
        }
        else {
            setImage(downImage);
        }
    }
    
    public void write(GreenfootImage image, String text1, String text2)
    {
        GreenfootImage tmp1 = new GreenfootImage(text1, 12, null, null);
        GreenfootImage tmp2 = new GreenfootImage(text2, 12, null, null);
        
        image.drawString(text1, (image.getWidth() - tmp1.getWidth()) / 2, 12);
        image.drawString(text2, (image.getWidth() - tmp2.getWidth()) / 2, 86);
    }
}
