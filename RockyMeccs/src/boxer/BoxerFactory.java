/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boxer;

import Interface.BoxerType;

/**
 *
 * @author FZs
 */
public class BoxerFactory {

    public Boxer getBoxer(BoxerType boxerType){
        switch (boxerType){
            case KEN:
                return new Ken();
            case ROCKY:
                return new Rocky();
            case BOXER:
                return new AnotherBoxer();    
            default:
                return null;
        }
    }
}
