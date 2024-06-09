import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Kristýna Míšková
 * @version 31. 5. 2024
 */
public class Level2 extends World
{
    int sirkaObrazovky = getWidth();
    int vyskaObrazovky = getHeight();
    int diraY = 50;
    
    public Level2()
    {    
        super(1200, 1000, 1); 
        setBackground("koulenipozadi.jpg");
        
        addObject(new Hrdina(), 75, (vyskaObrazovky/2)+10);
        addObject(new Trpaslik(), sirkaObrazovky - 100, vyskaObrazovky - 300);
        addObject(new PortalModry(), (sirkaObrazovky/5)*2, vyskaObrazovky/5);
        addObject(new PortalCerveny(), (sirkaObrazovky/5)*3, (vyskaObrazovky/5)*4);
        
        for(int i = 0; i < 10; i++) {
            addObject(new Dira(), sirkaObrazovky/2, diraY);
            diraY += 100;
        }
        
        showText("Mezerníkem pošlete kouli\nKoulí rozmražte trpaslíka", getWidth() - 300, getHeight()/6);
    }
}
