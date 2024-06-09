import greenfoot.*; 

/**
 * Pomocí "w" a "s" pohybujete s vozíkem, musíte zničit všechny trpaslíky v levelu pomocí kuličky - pozor ať vám nevyletí za vozík!
 * 
 * @author Helmichová Alexa
 * @version 31.5. 2024
 */
public class Level4 extends World
{
    int nahodneCislo = (Greenfoot.getRandomNumber(9) - 4) * 100;
    int tlacitkoJeVeSvete = 0;

    public Level4()
    {
        super(1200, 1000, 1); 
        setBackground("podlaha-level4v2.png");

        addObject(new Vozik(), getWidth()/15, getHeight()/2);
        addObject(new Koule(), getWidth()/5, getHeight()/2 + nahodneCislo);

        addObject(new Trpaslik(), (getWidth()/6)*5, (getHeight()/6)*4);
        addObject(new Trpaslik(), (getWidth()/6)*4, (getHeight()/6)*2);

        addObject(new Krabice(), (getWidth()/6)*5, (getHeight()/6)*3);
        addObject(new Krabice(), (getWidth()/6)*4, (getHeight()/6)*3);
        
        showText("Pomocí W a S jezděte s vozíkem\nZabraňte kouli, aby se dostala za vozík\nRozmražte všechny trpaslíky", getWidth() - 300, getHeight()/9);
    }

    public void act() {
        if(getObjects(Koule.class).size() == 0) {
            showText("Nevádí! Zkus to znovu!", getWidth()/2, getHeight()/2);
            addObject(new TlacitkoZnovu(), (getWidth()/3)*2, (getHeight()/3)*2);
            addObject(new TlacitkoMenu(), getWidth()/3, (getHeight()/3)*2);
        }
        if(getObjects(Trpaslik.class).size() == 0) {
            showText("Dobrá práce!", getWidth()/2, getHeight()/2);
            addObject(new TlacitkoZnovu(), (getWidth()/3)*2, (getHeight()/3)*2);
            addObject(new TlacitkoMenu(), getWidth()/3, (getHeight()/3)*2);
        }
    }
}
