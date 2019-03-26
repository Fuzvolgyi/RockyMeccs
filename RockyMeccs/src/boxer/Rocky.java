/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boxer;

/**
 *
 * @author FZs
 */
public class Rocky extends Boxer{

    private int extraPunchCounter = 0;
    
    public Rocky() {
        super.setName("Rocky");
        }

    @Override
    public int extraPunch(int str) {
        if (extraPunchCounter == 0 && this.getStrength() < 20 
                && rd.nextInt(100)+1 <= 30) {
            this.setStrength(this.getStrength() + 20);
            extraPunchCounter++;
            System.out.println("Rocky használta a különleges képességét!");
        }
        return 0;
    }

   
    
    
    
    
}
