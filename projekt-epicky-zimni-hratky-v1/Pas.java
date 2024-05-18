import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pas extends Actor
{
    int otoceni = 0;
    public Pas(String lokace) {
        if("rovneL".equals(lokace)) {
            otoceni = 0;
        }
        if("otoceneL".equals(lokace)) {
            setRotation(5);
        }
        if("rovneR".equals(lokace)) {
            otoceni = 0;
        }
        if("otoceneR".equals(lokace)) {
            setRotation(-5);
        }
    }
    public void act()
    {
        // Add your action code here.
    }
}
