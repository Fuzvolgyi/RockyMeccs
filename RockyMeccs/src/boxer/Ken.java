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
public class Ken extends Boxer {
    

    public Ken() {
        this.setName("Ken");
    }
    
    @Override
    public int extraPunch(int str) {
        if (str < 5 && rd.nextInt(100)+1 <= 20 ) {
            if (extraPunchCounter % 2 == 0) {
                System.out.println("Ken használta a különleges képességét!");    
            }
            extraPunchCounter++;
        }
        return 1;
    }
    
}
