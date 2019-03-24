/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxMatch;

import boxer.Boxer;
import java.util.Random;

/**
 *
 * @author FZs
 */
public class BoxMatch {

    private int threadCounter = 1;
    private boolean gameOver = false;
    private Boxer[] boxerList = new Boxer[2];
    Random rd = new Random();
    private StringBuilder sb;

    public BoxMatch(Boxer boxer1, Boxer boxer2) {
        boxerList[0] = boxer1;
        boxerList[1] = boxer2;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    void printBoxerList() {
        sb = new StringBuilder();
        for (int i = 0; i < boxerList.length; i++) {
            sb.append(threadCounter)
                    .append(". menetben ")
                    .append(boxerList[i].getName())
                    .append(" ").append(i)
                    .append(" ")
                    .append("erőnléte ")
                    .append(boxerList[i].getStrength())
                    .append(" utéserő ")
                    .append(boxerList[i].getPunchPower())
                    .append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    void boxThread() {
        sb = new StringBuilder();
        sb.append("Indul a ")
                .append(threadCounter)
                .append(". menet!");

        while (!gameOver) {

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
                }
            }
            printBoxerList();
            threadCounter++;
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
            boxerList[first].punch();
            boxerList[first - i].getaBlow(boxerList[first].getPunchPower());
            System.out.println(boxerList[first].getName() + first + " megütötte " + boxerList[first - i].getName());
            koTest(first - i);
        }
    }

    private void koTest(int i) {
        if (boxerList[i].getStrength() < 1) {
            setGameOver(true);
            System.out.println(boxerList[i].getName() + i + " kiesett!!!");
        }
    }

}
