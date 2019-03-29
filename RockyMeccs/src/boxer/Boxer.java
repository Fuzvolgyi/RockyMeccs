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

//</editor-fold>
    public void getaBlow(int punchPower) {
        this.strength = strength - punchPower;
    }

    public void punch() {
        int str = rd.nextInt(10) + 1;
        str += extraPunch(str);
        setPunchPower(str);
        printPunchType(str);
    }

    public int extraPunch(int str) {
        return 0;
    }

    private void printPunchType(int strength) {
        sb = new StringBuilder();
        sb.append(this.getName());
        if (strength % 2 == 0) {
            sb.append(" bal horgot vitt be.");
        } else {
            sb.append(" job egyenessel támadott.");
        }
        System.out.println(sb);
    }

}
