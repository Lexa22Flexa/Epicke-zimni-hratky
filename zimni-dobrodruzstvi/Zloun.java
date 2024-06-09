import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pohybuje se tam a zpátky v rovné čáře, brání střele v průletu
 * 
 * @author Kristýna Míšková
 * @version 22. 5. 2024
 */
public class Zloun extends Actor
{
    private int pocetKroku = 0;
    
    public Zloun() {
        turn(270);
    }
    public void act()
    {
        kracej();
        move(3);
        this.removeTouching(Koule.class);
    }
    public void kracej() {
        if (pocetKroku < 200) {
            pocetKroku++;
        }
        if (pocetKroku == 200) {
            turn(180);
            pocetKroku = 0;
        }
    }
}
