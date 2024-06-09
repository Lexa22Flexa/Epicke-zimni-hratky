import greenfoot.*;
import java.util.List;

/**
 * Ovládání koule
 * 
 * @author Helmichová Alexa, Šustková Veronika, Míšková Kristýna
 * @version 31.5. 2024
 */
public class Koule extends Actor
{
    public boolean moznostVystrelit = true;
    
    static int rychlostX = 6;
    static int rychlostY = 6;


    private void strilej() {
        List <Trpaslik> seznamTrpasliku= getIntersectingObjects(Trpaslik.class);
        
        for(Trpaslik trpaslik: seznamTrpasliku)
        {
            getWorld().removeObjects(seznamTrpasliku);
            int X = getX();
            int Y = getY();

            TrpaslikDruhy trpaslicek = new TrpaslikDruhy();
            getWorld().addObject(trpaslicek, X, Y);
        }

        move(10);
    }

    private void kontrolujPortaly() {
        if(isTouching(PortalModry.class)) {
            setLocation(701,868);
        }
        if(isTouching(PortalModryDva.class)) {
            setLocation(447,159);
        }
    }
    
    private void kontrolujOkraje() {
        if(isAtEdge()) {
            getWorld().removeObject(this);
        }
    }

    public void odrazZed() {
        int vyskaSveta = getWorld().getHeight();
        int sirkaSveta = getWorld().getWidth();
        int vyskaObrazku = getImage().getHeight()/2;
        int sirkaObrazku = getImage().getWidth()/2;

        if(getY() > vyskaSveta - vyskaObrazku || getY() < vyskaObrazku) {
            rychlostY = - rychlostY;
        }
        if(getX() > sirkaSveta - sirkaObrazku) {
            rychlostX = - rychlostX;
        }
        if(getX() < sirkaObrazku) {
            getWorld().removeObject(this);
        }
    }

    public void odrazObjekty() {
        Actor vozik = getOneIntersectingObject(Vozik.class);
        Actor trpaslik = getOneIntersectingObject(Trpaslik.class);
        Actor krabice = getOneIntersectingObject(Krabice.class);

        if(vozik != null && getX() > Vozik.poziceX - 99 && getX() < Vozik.poziceX + 99) {
            rychlostX = - rychlostX;
        }
        if(vozik != null && getY() > Vozik.poziceY - 219 && getY() < Vozik.poziceY + 219 && getX() < Vozik.poziceX + 45) {
            rychlostY = - rychlostY;
        }
        if(isTouching(Krabice.class)) {
            rychlostX = - rychlostX;
            rychlostY = - rychlostY;
        }
        if(isTouching(Trpaslik.class)) {
            rychlostX = - rychlostX;
            rychlostY = - rychlostY;
        }
    }

    public void act()
    {   
        if(getWorld() instanceof Level1) {
            strilej();
            kontrolujOkraje();
        }
        if(getWorld() instanceof Level2 || getWorld() instanceof Level21 || getWorld() instanceof Level22) {
            move(10);
            kontrolujPortaly();
            kontrolujOkraje();
        }
        if(getWorld() instanceof Level4) {
            setLocation(getX() + rychlostX, getY() + rychlostY);

            odrazObjekty();
            odrazZed();
        }
    }
}