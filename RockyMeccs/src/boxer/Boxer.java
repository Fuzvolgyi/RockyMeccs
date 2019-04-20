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
public abstract class Boxer {

    private String name;
    private int strength = 100;
    private int punchPower;
    protected int extraPunchCounter = 0;
    private StringBuilder sb;
    protected static Random rd = new Random();

    static {
        rd = new Random();
    }

    //<editor-fold defaultstate="collapsed" desc="Getter-Setter">
    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getPunchPower() {
        return punchPower;
    }

    public void setPunchPower(int punchPower) {
        this.punchPower = punchPower;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getExtraPunchCounter() {
        return extraPunchCounter;
    }

//</editor-fold>
    public void getaBlow(int punchPower) {
        this.strength = strength - punchPower;
    }

    public void punch() {
        int str = rd.nextInt(10) + 1;
        str += extraPunch(str);
        setPunchPower(str);
    }

    int extraPunch(int str) {
        return 0;
    }

}
