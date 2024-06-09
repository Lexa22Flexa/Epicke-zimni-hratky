import greenfoot.*;

/**
 * Vozíkem posuňte stisknutím kláves "w" a "s".
 * 
 * @author Helmichová Alexa
 * @version 22.5. 2024
 */
public class Vozik extends Actor
{
    int rychlost = 6;
    static int poziceX;
    static int poziceY;

    public void ovladani() {
        if(Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - rychlost);
        }
        if(Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + rychlost);
        }
    }

    public void detekceOkraje() {
        int vyskaSveta = getWorld().getHeight();
        int vyskaObrazku = getImage().getHeight()/2;

        if(getY() < vyskaObrazku) {
            setLocation(getX(), getY() + rychlost);
        }
        if(getY() > vyskaSveta - vyskaObrazku) {
            setLocation(getX(), getY() - rychlost);
        }
    }

    public void act()
    {
        poziceX = getX();
        poziceY = getY();

        ovladani();
        detekceOkraje();
    }
}
