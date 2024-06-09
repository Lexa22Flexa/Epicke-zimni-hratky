import greenfoot.*; 

/**
 * Musíte pomoct trpaslíkům se dostat nahoru k východu. Klikněte na ně u pece, aby se rozmrazili, klikněte na ně u žebříku, aby na něj vylezli.
 * 
 * @author Helmichová Alexa
 * @version 31.5. 2024
 */
public class Level3 extends World
{
    int poziceXP = (getWidth()*183)/1000;
    int poziceYP = getHeight()/6;
    int poziceXZ = (getWidth()/34)*10;
    int poziceYZ = (getHeight()/38)*10;
    int pocitadloT = 700;
    int obtiznost = 700;
    int pocitadloS = 60;
    int sanceS;
    int pocitaniOvladani;

    public Level3()
    {
        super(1200, 1000, 1); 
        setBackground("pozadi-level3.png");
        pocitaniOvladani = 100;

        objekty();
        
        showText("Klikněte na pec pro rozmražení trpaslíka\nKlikněte na trpaslíka u žebříku\nDostaňte 20 trpaslíků k východu vlevo nahoře!", getWidth() - 300, getHeight()/9);
    }

    public void objekty() {
        for(int i = 0; i < 2; i++) {
            addObject(new Pas("otoceneL"), poziceXP, poziceYP);
            addObject(new Pas("otoceneL"), poziceXP*3, poziceYP+50);
            poziceYP += 220;
            poziceXP += 40;
            addObject(new Pas("rovne"), 260, poziceYP);
            addObject(new Pas("rovne"), (getWidth()/5)*3, poziceYP);
            poziceYP += (getHeight()*22)/100;
        }
        
        addObject(new Zebrik(), poziceXZ, poziceYZ);
        addObject(new Zebrik(), poziceXZ*2+(getWidth()/10), poziceYZ+(getHeight()/30));
        poziceXZ = (poziceXZ*3)/10;
        poziceYZ = (poziceYZ*184)/100;
        addObject(new Zebrik(), poziceXZ, poziceYZ);
        addObject(new Zebrik(), poziceXZ*6, (poziceYZ*13)/12);
        poziceXZ = (poziceXZ*38)/10;
        poziceYZ = (poziceYZ*15)/10;
        addObject(new Zebrik(), (poziceXZ*11)/5, poziceYZ);
        addObject(new Zebrik(), poziceXZ, poziceYZ);
        addObject(new Pec(), (getWidth()*15)/100, (getHeight()*7)/10);
        addObject(new Vychod(), 0, getHeight()/10);
    }

    private void trpaslici() {
        if(pocitadloT != 0) {
            pocitadloT--;
        }
        if(pocitadloT == 0) {
            addObject(new Trpaslik(), 100, 735);
            pocitadloT += obtiznost;
            obtiznost -= 30;
        }
        if(obtiznost < 40) {
            obtiznost = 170;
        }
    }

    public void act() {
        trpaslici();

        showText("Body: " + Trpaslik.body, getWidth() - 100, 50);
        
        if(Trpaslik.body >= 1) {
            showText("Dobrá práce!", getWidth()/2, getHeight()/2);
            addObject(new TlacitkoZnovu(), (getWidth()/3)*2, (getHeight()/3)*2);
            addObject(new TlacitkoMenu(), getWidth()/3, (getHeight()/3)*2);
        }
        if(Trpaslik.body < 0) {
            showText("Nevádí! Zkus to znovu!", getWidth()/2, getHeight()/2);
            addObject(new TlacitkoZnovu(), (getWidth()/3)*2, (getHeight()/3)*2);
            addObject(new TlacitkoMenu(), getWidth()/3, (getHeight()/3)*2);
        }
    }
}
