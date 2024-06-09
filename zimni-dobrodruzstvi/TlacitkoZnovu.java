import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Klikněte, aby jste si znovu zahráli level.
 * 
 * @author Helmichová Alexa
 * @version 22.5. 2024
 */
public class TlacitkoZnovu extends Actor
{
    public void zmeneniSveta() {
        if(Greenfoot.mouseClicked(this)) {
            if(getWorld() instanceof Level1) {
                Greenfoot.setWorld(new Level1());
            }
            if(getWorld() instanceof Level22) {
                Greenfoot.setWorld(new Level2());
            }
            if(getWorld() instanceof Level3) {
                Trpaslik.body = 0;
                Greenfoot.setWorld(new Level3());
            }
            if(getWorld() instanceof Level4) {
                Greenfoot.setWorld(new Level4());
            }
        }
    }

    public void act() {
        zmeneniSveta();
    }
}
