import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HlavniObrazovka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HlavniMenu extends World
{
    private int urceniCisla = 0;
    private int urceniDelky = 0;
    
    public HlavniMenu()
    {    
        super(1200, 1000, 1);
        setBackground("pozadi-hlavnimenu.png");
        
        for(int i = 0; i < 4; i++) {
            urceniCisla++;
            urceniDelky++;
            addObject(new TlacitkoLevel(urceniCisla), getWidth()/5*urceniDelky, (getHeight()/3)*2);
        }
    }
}
