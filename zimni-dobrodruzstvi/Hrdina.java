import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hází střely mezerníkem, otáčí se za myší
 * 
 * @author Kristýna Míšková
 * @version 22. 5. 2024
 */
public class Hrdina extends Actor
{
    public void act()
    {
        otocSeZaMysi();
        strileni();
    }
    
    public void otocSeZaMysi() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            int x = mi.getX();
            int y = mi.getY();
            turnTowards(x, y);
        }
    }
    
    public void strileni() {
        String klavesa = Greenfoot.getKey();
        if (klavesa == "space") {
            Koule strela = new Koule();
            getWorld().addObject(strela, getX(), getY());
            strela.setRotation(getRotation());
        }
    }
}
