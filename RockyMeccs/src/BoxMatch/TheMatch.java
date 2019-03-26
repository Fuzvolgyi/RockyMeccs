
package BoxMatch;

import boxer.Ken;
import boxer.Boxer;
import boxer.Rocky;

/**
 *
 * @author FZs
 */
public class TheMatch {
    
    public static void main(String[] args) {
        
        Boxer boxer1 = new Rocky();
        Boxer boxer2 = new Ken();
        BoxMatch Match = new BoxMatch(boxer1, boxer2);
        
        Match.boxRound();
    }
}
