/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxer;

import java.util.Random;

/**
 *
 * @author FZs
 */
public class Boxer {

    String name = "Boxer";
    private int strength = 100;
    private int punchPower;
    private StringBuilder sb;
    Random rd = new Random();

    public Boxer() {
        this.sb = new StringBuilder();
    }

    //<editor-fold defaultstate="collapsed" desc="Getter-Setter">
    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getPunchPower() {
        return punchPower;
    }

    public void setPunchPower(int punchPower) {
        this.punchPower = punchPower;
    }
    
//</editor-fold>
    
    public void addSb(String str) {
        this.sb.append(str);
    }

    public void getaBlow(int punchPower) {
        this.strength = strength - punchPower;
    }

    public void punch() {
        setPunchPower(rd.nextInt(10) + 1);
    }

    public void extraPunch() {

    }

}
