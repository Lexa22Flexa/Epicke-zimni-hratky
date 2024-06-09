import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Zruší střelu pokud do ní dopadne
 * 
 * @author Kristýna Míšková
 * @version 22. 5. 2024
 */
public class Dira extends Actor
{
    public void act()
    {
        this.removeTouching(Koule.class);
    }
}
