import greenfoot.*;

/**
 * Natočení pásů.
 * 
 * @author Helmichová Alexa
 * @version 22.5. 2024
 */
public class Pas extends Actor
{
    public Pas() {
        
    }
    
    public Pas(String lokace) {
        if("rovne".equals(lokace)) {
            setRotation(0);
        }
        if("otoceneL".equals(lokace)) {
            setRotation(4);
        }
        if("otoceneR".equals(lokace)) {
            setRotation(-4);
        }
    }
}
