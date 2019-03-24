
package BoxMatch;

import boxer.Boxer;

/**
 *
 * @author FZs
 */
public class TheMatch {
    
    public static void main(String[] args) {
        
        Boxer boxer1 = new Boxer();
        Boxer boxer2 = new Boxer();
        BoxMatch Match = new BoxMatch(boxer1, boxer2);
        
        Match.printBoxerList();
        Match.boxThread();
    }
}
