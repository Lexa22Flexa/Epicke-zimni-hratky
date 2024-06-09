import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level22 here.
 * 
 * @author Kristýna Míšková
 * @version 22. 5. 2024
 */
public class Level22 extends World
{
    int sirkaObrazovky = getWidth();
    int vyskaObrazovky = getHeight();
    private int pocetSten = 6;
    final int prvniStena = 116;
    final int rozestup = 100;
    int poziceStenyX = 358;
    int poziceStenyY = prvniStena;

    public Level22()
    {
        super(1200, 1000, 1); 
        setBackground("koulenipozadi.jpg");
        
        while (pocetSten > 0) {
            addObject(new Dira(), poziceStenyX, poziceStenyY);
            poziceStenyY += rozestup;
            pocetSten--;
        }
        
        addObject(new Hrdina(), 75, (vyskaObrazovky/2)+10);
        addObject(new Trpaslik(), sirkaObrazovky - 100, (vyskaObrazovky/7)*5);
        addObject(new Zloun(), (sirkaObrazovky/3)*2, (vyskaObrazovky/3)*2);
        addObject(new PortalModryDva(), sirkaObrazovky/4, (vyskaObrazovky*7)/10);
        addObject(new PortalCerveny(), (sirkaObrazovky*36)/100, (vyskaObrazovky*16)/100);
    }
}
