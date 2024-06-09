import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * rozmražování trpasliku 
 * 
 * @author Šustková Veronika
 * @version 31.5. 2024
 */
public class Level1 extends World
{
    int sirkaObrazovky = getWidth();
    int vyskaObrazovky = getHeight();
    int portalL = 10;
    int portalR = sirkaObrazovky - 10;
    int portalY = vyskaObrazovky/2;
    int trpaslikY = portalY;
    
    public Level1()
    {
        super(1200, 800, 1); 
        setBackground("pozadi-level1.png");

        addObject(new Delo(), 100, 250);
        
        for(int i = 0; i < 2; i++) {
            addObject(new ZachrannyPortal(), portalL, portalY);
            addObject(new ZachrannyPortal(), portalR, portalY);
            portalY += vyskaObrazovky/5;
        }
        
        for(int i = 0; i < 3; i++) {
            addObject(new Trpaslik(), Greenfoot.getRandomNumber(1200), trpaslikY);
            trpaslikY += vyskaObrazovky/5;
            addObject(new Trpaslik(), Greenfoot.getRandomNumber(1200), trpaslikY);
            trpaslikY -= vyskaObrazovky/5;
        }
        
        addObject(new Bomba(), Greenfoot.getRandomNumber(1200), trpaslikY);
            
        showText("Účel hry: Za myší se otáčí obsluha děla a mezerníkem střílí kuličky,\ndíky kterým se rozmrazí trpaslíci a ty šipkami VPRAVO a VLEVO odnést do portálu\nOsvoboď dohromady 10 trpaslíků\nPokud trefíš kuličkou bombu, je konec hry:(" , 600, 150);
    }
    
    public void act() {
        if(getObjects(Trpaslik.class).size() == 0) {
            showText("Dobrá práce!", getWidth()/2, getHeight()/2);
            addObject(new TlacitkoZnovu(), (getWidth()/3)*2, (getHeight()/3)*2);
            addObject(new TlacitkoMenu(), getWidth()/3, (getHeight()/3)*2);
            Delo.kontrolaStrileni = false;
        }
    }
}