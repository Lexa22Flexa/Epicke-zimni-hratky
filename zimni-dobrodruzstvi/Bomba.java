import greenfoot.*; 

/**
 * rozmražování trpaslíků
 * 
 * @author Šustková Veronika
 * @version 22.5. 2024
 */
public class Bomba extends Actor
{
    private int rychlost = 3;

    public void act()
    {
        move(5);

        if(isAtEdge())
        {
            turn(180);
            setLocation(getX(), getY()-130);
            int Y = getY();

            if (Y < 420)
            {
                setLocation(getX(), getY()+180);
            }
        }

        if(isTouching(Koule.class))
        {
            int vyskaObrazovky = getWorld().getHeight();
            int sirkaObrazovky = getWorld().getWidth();
            
            getWorld().showText("Nevádí! Zkus to znovu!", sirkaObrazovky/2, vyskaObrazovky/2);
            getWorld().addObject(new TlacitkoZnovu(), (sirkaObrazovky/3)*2, (vyskaObrazovky/3)*2);
            getWorld().addObject(new TlacitkoMenu(), sirkaObrazovky/3, (vyskaObrazovky/3)*2);
            Delo.kontrolaStrileni = false;
        }
    }
}
