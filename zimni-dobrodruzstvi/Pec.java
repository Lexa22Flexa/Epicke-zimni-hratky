import greenfoot.*;

/**
 * Klikněte na pec, aby rozmrazila trpaslíky, kterých se dotýká.
 * 
 * @author Helmichová Alexa
 * @version 22.5. 2024
 */
public class Pec extends Actor
{
    private int pocitani = 30;

    public void act()
    {
        if(Greenfoot.mouseClicked(this)) {
            setImage("pec-zapalena.png");
            pocitani--;
        }
        if(pocitani < 30) {
            setImage("pec-zapalena.png");
            pocitani--;
        }
        if(pocitani < 0) {
            setImage("pec.png");
            pocitani = 30;
        }
    }
}
