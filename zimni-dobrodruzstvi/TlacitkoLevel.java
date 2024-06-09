import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Klikněte na tlačítko levelu, který si chcete zahrát.
 * 
 * @author Helmichová Alexa
 * @version 22.5. 2024
 */
public class TlacitkoLevel extends Actor
{
    int level;

    public TlacitkoLevel(int level) {
        this.level = level;
        switch(this.level) {
            case 1:
                setImage("tlacitko-level1.png");
                break;
            case 2:
                setImage("tlacitko-level2.png");
                break;
            case 3:
                setImage("tlacitko-level3.png");
                break;
            case 4:
                setImage("tlacitko-level4.png");
                break;
        }
    }

    private void urceniLevelu() {
        switch(this.level) {
            case 1:
                if(Greenfoot.mouseClicked(this)) {
                    Greenfoot.setWorld(new Level1());
                }
                break;
            case 2:
                if(Greenfoot.mouseClicked(this)) {
                    Greenfoot.setWorld(new Level2());
                }
                break;
            case 3:
                if(Greenfoot.mouseClicked(this)) {
                    Greenfoot.setWorld(new Level3());
                }
                break;
            case 4:
                if(Greenfoot.mouseClicked(this)) {
                    Greenfoot.setWorld(new Level4());
                }
                break;
        }
    }

    public void act()
    {
        urceniLevelu();
    }
}
