import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    int poziceXP = 220;
    int poziceYP = 150;
    int poziceXZ = 350;
    int poziceYZ = 260;
    int pocitadloT = 3;
    int obtiznost = 500;
    int pocitadloS = 60;
    int sanceS;
    
    public Level3()
    {
        super(1200, 900, 1); 
        objekty();

        /*poziceYZ += 220;
        poziceXZ += 240;
        addObject(new Zebrik(), poziceXZ, poziceYZ);
        poziceYZ += 220;
        poziceXZ -= 240;
        addObject(new Zebrik(), poziceXZ, poziceYZ);*/
    }

    public void objekty() {
        for(int i = 0; i < 2; i++) {
            addObject(new Pas("otoceneL"), poziceXP, poziceYP);
            poziceYP += 220;
            poziceXP += 40;
            addObject(new Pas("rovneL"), 260, poziceYP);
            poziceYP += 220;
        }
        addObject(new Zebrik(), poziceXZ, poziceYZ);
        poziceXZ -= 250;
        poziceYZ += 210;
        addObject(new Zebrik(), poziceXZ, poziceYZ);
        poziceXZ += 300;
        poziceYZ += 230;
        addObject(new Zebrik(), poziceXZ, poziceYZ);
        addObject(new Pec(), 180, 700);
        addObject(new Vychod(), 0, 80);
    }

    public void trpaslici() {
        if(pocitadloT != 0) {
            pocitadloT--;
        }
        if(pocitadloT == 0) {
            addObject(new Trpaslik(), 100, 735);
            pocitadloT += obtiznost;
            obtiznost -= 20;
        }
    }
    
    public void sudy() {
        if(pocitadloS == 0) {
            sanceS = Greenfoot.getRandomNumber(5);
            addObject(new Sud(), 50, 5);
        }
    }
    
    public void act() {
        trpaslici();
        
        showText("body: " +Trpaslik.body, 800, 100);
    }
}
