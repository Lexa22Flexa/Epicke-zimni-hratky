import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Trpaslik here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trpaslik extends Actor
{
    int rychlost = 2;
    boolean pad = false;
    boolean otocitSmer = false;
    boolean detZebrik = false;
    boolean zastavit = false;
    boolean zamrazeni = true;
    int dotykaniZebrik = -2;
    public static int body = 0;
    
    public void detekcePodlahy() {
        if(isTouching(Pas.class) || isTouching(Zebrik.class)) {
            pad = false;
        } else {
            pad = true;
        }
        if(pad == true) {
            setLocation(getX() - 1, getY() + 2);
        }
    }
    
    public void otoceniSmeru() {
        if(otocitSmer == true) {
            setRotation(10);
            rychlost = -2;
            getWorld().showText("kms", 100, 100);
        }
        if(otocitSmer != true) {
            setRotation(0);
            rychlost = 2;
            getWorld().showText("chci chcípnou", 300, 300);
        }
    }
    
    public void zastaveniPohybu() {
        if(zastavit = true) {
            rychlost = 0;
        }
    }
    
    public void detekceOkraje () {
        if(isAtEdge() || isTouching(Vychod.class)) {
            getWorld().removeObject(this);
        }
    }
    
    public void detekceZebriku() {
        if(isTouching(Zebrik.class) && Greenfoot.mouseClicked(this)) {
            zastavit = true;
            dotykaniZebrik = 50;
        }
        if(dotykaniZebrik > 2) {
            setLocation(getX(), getY() - 5);
            zastaveniPohybu();
        }
        if(dotykaniZebrik > 0) {
            dotykaniZebrik--;
        }
        if(otocitSmer == true && dotykaniZebrik == 1) {
            otocitSmer = false;
            otoceniSmeru();
            dotykaniZebrik--;
        }
        if(otocitSmer != true && dotykaniZebrik == 1) {
            otocitSmer = true;
            otoceniSmeru();
            dotykaniZebrik--;
        }
    }
    
    public void rozmrazeni() {
        Actor pecL;
        pecL = getOneIntersectingObject(Pec.class);
        if(isTouching(Pec.class) && Greenfoot.mouseClicked(pecL)) {
            zamrazeni = false;
        }
        if(zamrazeni != false) {
            setImage("zamrzly-trpaslik.png");
        }
        if(zamrazeni == false) {
            setImage("trpaslik.png");
        }
    }
    
    public void poctyBodu() {
        if(isTouching(Vychod.class)) {
            body++;
        }
        if(isAtEdge()) {
            body--;
        }
    }
    
    public void act()
    {
        detekcePodlahy();
        rozmrazeni();
        if(zamrazeni == false) {
            detekceZebriku();
        }
        move(rychlost);
        
        poctyBodu();
        detekceOkraje();
    }
}
