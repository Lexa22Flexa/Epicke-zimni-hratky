import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Chování trpaslíků v různých levelech.
 * 
 * @author Helmichová Alexa, Šustková Veronika, Míšková Kristýna
 * @version 22.5. 2024
 */
public class Trpaslik extends Actor
{
    public int level = 1;
    
    boolean nechObrazek = false;
    
    int rychlost = 2;
    boolean pad = false;
    boolean otocitSmer = false;
    boolean detZebrik = false;
    boolean zastavit = false;
    boolean zamrazeni = true;
    int dotykaniZebrik = -2;
    public static int body = 0;
    int pocitaniKol = 300;

    int stavRozmrazeni = 0;
    public static int sirkaObrazku;
    public static int vyskaObrazku;
    public static int poziceX;
    public static int poziceY;
    int pocitadlo = 10;

    public Trpaslik() {
        setImage("skretvledu.png");
        if(getWorld() instanceof Level3) {
            body = 0;
        }
    }
    
    private void pohyb()
    {
        move(-5);
        if(isAtEdge())
        {
            turn(180);
        }
    }
    
    private void meneniSe() {
        GreenfootImage myImage;
        myImage = new GreenfootImage("skretvledu.png");
        if (isTouching(Koule.class) && getWorld() instanceof Level2) {
            myImage = new GreenfootImage("skret.png");
            setImage(myImage);
            this.removeTouching(Koule.class);
            Greenfoot.delay(30);
            Greenfoot.setWorld(new Level21());
        }
        else if (isTouching(Koule.class) && getWorld() instanceof Level21) {
            myImage = new GreenfootImage("skret.png");
            setImage(myImage);
            this.removeTouching(Koule.class);
            Greenfoot.delay(30);
            Greenfoot.setWorld(new Level22());
        }
        else if (isTouching(Koule.class) && getWorld() instanceof Level22) {
            int vyskaObrazovky = getWorld().getHeight();
            int sirkaObrazovky = getWorld().getWidth();
            myImage = new GreenfootImage("skret.png");
            setImage(myImage);
            this.removeTouching(Koule.class);
            nechObrazek = true;
            
            getWorld().showText("Osvobodil jsi všechny skřety v tomhle levelu!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            getWorld().addObject(new TlacitkoZnovu(), (sirkaObrazovky/3)*2, (vyskaObrazovky/3)*2);
            getWorld().addObject(new TlacitkoMenu(), sirkaObrazovky/3, (vyskaObrazovky/3)*2);
        }
        setImage(myImage);
        if(nechObrazek == true) {
            setImage("skret.png");
        }
    }
    
    private void detekcePodlahy() {
        if(isTouching(Pas.class) || isTouching(Zebrik.class)) {
            pad = false;
        } else {
            pad = true;
        }
        if(pad == true) {
            setLocation(getX() - 1, getY() + 2);
        }
    }

    private void otoceniSmeru() {
        if(otocitSmer == true) {
            setRotation(10);
            rychlost = -2;
        }
        if(otocitSmer != true) {
            setRotation(0);
            rychlost = 2;
        }
    }

    private void zastaveniPohybu() {
        if(zastavit = true) {
            rychlost = 0;
        }
    }

    private void detekceOkraje () {
        if(isAtEdge() || isTouching(Vychod.class)) {
            getWorld().removeObject(this);
        }
    }

    private void detekceZebriku() {
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

    private void rozmrazeni() {
        Actor pecL = getOneIntersectingObject(Pec.class);
        Actor koule = getOneIntersectingObject(Koule.class);

        if(pocitadlo > 0) {
            pocitadlo--;
        }
        if(koule != null && pocitadlo == 0) {
            stavRozmrazeni++;
            pocitadlo = 20;
        }

        if(isTouching(Pec.class) && Greenfoot.mouseClicked(pecL) || stavRozmrazeni >= 3) {
            zamrazeni = false;
        }
        if(zamrazeni != false) {
            if(getWorld() instanceof Level3) {
                setImage("skretvledu.png");
            }
            if(getWorld() instanceof Level4) {
                setImage("skretvledu.png");
            }
        }
        if(zamrazeni == false) {
            if(getWorld() instanceof Level3) {
                setImage("skret.png");
            }
        }
        if(getWorld() instanceof Level4) {
            switch (stavRozmrazeni) {
                case 1:
                    setImage("skretvledu-2.png");
                    break;
                case 2:
                    setImage("skretvledu-3.png");
                    break;
                case 3:
                    setImage("skret.png");
                    move(5);
                    if(isAtEdge()) {
                        getWorld().removeObject(this);
                    }
                    break;
                default:
                    setImage("skretvledu.png");
            }
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

    public void zvyseniObtiznosti() {
        pocitaniKol--;

        if(pocitaniKol == 0) {
            rychlost += 2;
        }
    }

    public void act()
    {
        if(getWorld() instanceof Level1) {
            setImage("skretvledu.png");
            pohyb();
        }
        
        if(getWorld() instanceof Level2 || getWorld() instanceof Level21 || getWorld() instanceof Level22) {
            meneniSe();
        }
        
        if(getWorld() instanceof Level3) {
            detekcePodlahy();
            if(zamrazeni == false) {
                detekceZebriku();
            }
            move(rychlost);

            rozmrazeni();
            zvyseniObtiznosti();
            poctyBodu();
            detekceOkraje();
        }

        if(getWorld() instanceof Level4) {
            poziceX = getX();
            poziceY = getY();
            if(pocitadlo > 0) pocitadlo--;
            rozmrazeni();
        }
    }
}