
package BoxMatch;

import Interface.BoxerType;
import boxer.Boxer;
import boxer.BoxerFactory;

/**
 *
 * @author FZs
 */
public class TheMatch {
    
    
    public static void main(String[] args) {
        BoxerFactory boxerFactory = new BoxerFactory();
        
        Boxer boxer1 = boxerFactory.getBoxer(BoxerType.KEN);
        Boxer boxer2 = boxerFactory.getBoxer(BoxerType.ROCKY);
        
        BoxMatch Match = new BoxMatch(boxer1, boxer2);
        
        Match.boxRound();
    }
}
