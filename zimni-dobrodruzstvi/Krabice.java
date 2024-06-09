import greenfoot.*;

/**
 * Krabice pro blokaci v cestě koule.
 * 
 * @author Helmichová Alexa
 * @version 22.5. 2024
 */
public class Krabice extends Actor
{
    public void rozbiti() {
        if(isTouching(Koule.class)) {
            getWorld().removeObject(this);
        }
    }

    public void act()
    {
        rozbiti();
    }
}
