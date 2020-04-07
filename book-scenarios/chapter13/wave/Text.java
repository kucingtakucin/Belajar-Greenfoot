import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.font.FontRenderContext;
import java.awt.Graphics2D;

/**
 * This class provides objects that just show a bit of text on the screen.
 * @version 1.1
 */
public class Text extends Actor
{
    public Text(String text)
    {
        setImage(new GreenfootImage(text, 14, null, null));
    }

    public void setText(String text)
    {
        setImage(new GreenfootImage(text, 14, null, null));        
    }
}
