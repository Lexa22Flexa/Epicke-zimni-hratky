import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level21 here.
 * 
 * @author Kristýna Míšková
 * @version 22. 5. 2024
 */
public class Level21 extends World
{
    int sirkaObrazovky = getWidth();
    int vyskaObrazovky = getHeight();
    int zlounX = sirkaObrazovky/3;
    int zlounY = vyskaObrazovky - 300;
    
    public Level21()
    {    
        super(1200, 1000, 1); 
        setBackground("koulenipozadi.jpg");
        
        addObject(new Hrdina(), 75, (vyskaObrazovky/2)+10);
        addObject(new Trpaslik(), sirkaObrazovky - 100, vyskaObrazovky/2);
        
        for(int i = 0; i < 3; i++) {
            addObject(new Zloun(), zlounX, zlounY);
            zlounX += sirkaObrazovky/6;
        }
    }
}
