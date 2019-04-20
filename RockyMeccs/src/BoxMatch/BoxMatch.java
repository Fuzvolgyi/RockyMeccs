package BoxMatch;

import boxer.Boxer;
import java.util.Random;

/**
 *
 * @author FZs
 */
public class BoxMatch {

    private boolean gameOver = false;
    private final Boxer[] BOXERLIST = new Boxer[2];
    Random rd = new Random();
    
    public BoxMatch(Boxer boxer1, Boxer boxer2) {
        BOXERLIST[0] = boxer1;
        BOXERLIST[1] = boxer2;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Boxer[] getBOXERLIST() {
        return BOXERLIST;
    }

    
    
    public void boxRound() {
        for (int i = 0; i < BOXERLIST.length; i++) {
            koTest(i);
        }
        if (!gameOver) {
            int counterPunch = 0;
            int first = rd.nextInt(2);
            while (counterPunch < 2) {
                switch (first) {
                    case 0:
                        fight(0);
                        counterPunch++;
                        first++;
                        break;
                    case 1:
                        fight(1);
                        counterPunch++;
                        first--;
                        break;
                }
            }
        }

    }

    private void fight(int first) {
        int i;
        if (first == 0) {
            i = -1;
        } else {
            i = 1;
        }
        if (!gameOver) {
            BOXERLIST[first].punch();
            BOXERLIST[first - i].getaBlow(BOXERLIST[first].getPunchPower());
            koTest(first - i);
        }
    }

    private void koTest(int i) { 
        if (BOXERLIST[i].getStrength() < 1) {
            gameOver = true;
        }
    }
    
    public String winner(){
        return BOXERLIST[0].getStrength() < 1 ? BOXERLIST[1].getName() : BOXERLIST[0].getName();
    }
}
