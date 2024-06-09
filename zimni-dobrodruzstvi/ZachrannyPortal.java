import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * rozmražování trpaslíků
 * 
 * @Veronika Šustková
 * @22.5. 2024
 */
public class ZachrannyPortal extends Actor

{
    public void act()
    {   
        List <TrpaslikDruhy> seznamTrpaslika = getIntersectingObjects(TrpaslikDruhy.class);
        for (TrpaslikDruhy trpaslicek : seznamTrpaslika)
        {
            getWorld().removeObjects(seznamTrpaslika);
            Trpaslik nahradniTrpaslik = new Trpaslik();
            getWorld().addObject(nahradniTrpaslik,Greenfoot.getRandomNumber(1200),480);
        }
    }
}