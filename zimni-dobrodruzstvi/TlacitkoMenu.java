import greenfoot.*; 

/**
 * Klikněte na tlačítko, aby vás vzalo do hlavního menu.
 * 
 * @author Helmichová Alexa
 * @version 22.5. 2024
 */
public class TlacitkoMenu extends Actor
{ 
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) { 
            Greenfoot.setWorld(new HlavniMenu());
        }
    }
}
