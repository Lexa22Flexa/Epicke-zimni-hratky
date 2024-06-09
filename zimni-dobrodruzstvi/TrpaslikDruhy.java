import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * rozmražování trpasliku 
 * 
 * @author Šustková Veronika
 * @version 31.5. 2024
 */

public class TrpaslikDruhy extends Actor

{
    public void pohyb()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-4,getY());
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+ 4,getY());
        }
    }
    
    public void act()
    {
        pohyb();
    }

}