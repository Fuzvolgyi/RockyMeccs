/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import BoxMatch.BoxMatch;
import Interface.BoxerType;
import boxer.Boxer;
import boxer.BoxerFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author FZs
 */
public class BoxMatchFXMLController implements Initializable {

    @FXML
    AnchorPane AnchorPane;
    @FXML
    SplitPane mainPane;
    @FXML
    Label labelThreadCounter;
    @FXML
    Button buttonGo;
    @FXML
    TextArea textAreaMain;
    @FXML
    Button buttonExit;
    @FXML
    Button buttonNewMatch;

    @FXML
    AnchorPane redCorner;
    @FXML
    TextField tfRedName;
    @FXML
    TextField tfRedStrength;
    @FXML
    TextField tfRedPunchPower;

    @FXML
    AnchorPane blueCorner;
    @FXML
    TextField tfBlueName;
    @FXML
    TextField tfBlueStrength;
    @FXML
    TextField tfBluePunchPower;

    @FXML
    Pane menu;
    @FXML
    Label labelAlert;
    @FXML
    Button btStartTheMatch;
    @FXML
    VBox checkBoxes;
    @FXML
    CheckBox checkBoxRocky;
    @FXML
    CheckBox checkBoxKen;
    @FXML
    CheckBox checkBoxBoxer;

    private BoxMatch boxMatch;
    private Boxer boxer1;
    private Boxer boxer2;
    private int threadCounter;
    private int boxer1PounchCounter;
    private int boxer2PounchCounter;
    private ArrayList boxerTypeList = new ArrayList();
    private StringBuilder sb;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mainPane.setVisible(false);
        menu.setVisible(true);
    }

    @FXML
    private void btStartTheMatch(ActionEvent event) {
        createBoxerList();
        if (!voteIsValid()) {
            labelAlert.setText("Két boxolót válassz ki a mecshez!");
        } else {
            labelAlert.setText(null);
            createBoxers();
            menu.setVisible(false);
            mainPane.setVisible(true);
            buttonExit.setVisible(false);
            buttonNewMatch.setVisible(false);
            buttonGo.setVisible(true);
            buttonGo.setText("Induljon a mecs!");
            textAreaMain.clear();
            labelThreadCounter.setText("");
            threadCounter = 1;
            showBoxersState();
        }

    }

    private void createBoxerList() {
        boxerTypeList.clear();
        if (checkBoxRocky.isSelected()) {
            boxerTypeList.add(BoxerType.ROCKY);
        }
        if (checkBoxKen.isSelected()) {
            boxerTypeList.add(BoxerType.KEN);
        }
        if (checkBoxBoxer.isSelected()) {
            boxerTypeList.add(BoxerType.BOXER);
        }
    }

    private boolean voteIsValid() {
        return boxerTypeList.size() == 2;
    }

    private void createBoxers() {
        BoxerFactory boxerFactory = new BoxerFactory();
        boxer1 = boxerFactory.getBoxer((BoxerType) boxerTypeList.get(0));
        boxer2 = boxerFactory.getBoxer((BoxerType) boxerTypeList.get(1));
        boxMatch = new BoxMatch(boxer1, boxer2);
    }

    private void showBoxersState() {

        tfRedName.setText(boxer1.getName());
        tfRedStrength.setText(String.valueOf(boxer1.getStrength()));
        if (boxer1.getPunchPower() < 1) {
            tfRedPunchPower.setText("");
        } else {
            tfRedPunchPower.setText(String.valueOf(boxer1.getPunchPower()));
        }

        tfBlueName.setText(boxer2.getName());
        tfBlueStrength.setText(String.valueOf(boxer2.getStrength()));
        if (boxer2.getPunchPower() < 1) {
            tfBluePunchPower.setText("");
        } else {
            tfBluePunchPower.setText(String.valueOf(boxer2.getPunchPower()));
        }
    }

    private void showMediation() {
        
        printPunchType(boxer1);
        sb.append(System.lineSeparator());
        printPunchType(boxer2);
        
        textAreaMain.setText(sb.toString());

    }

    private void printPunchType(Boxer boxer) {
        sb.append(boxer.getName());
        if (boxer.getStrength() % 2 == 0) {
            sb.append(" bal horgot vitt be.");
        } else {
            sb.append(" job egyenessel támadott.");
        }

    }

    @FXML
    private void ButtonGo(ActionEvent event) {
        boxer1PounchCounter = boxer1.getExtraPunchCounter();
        boxer2PounchCounter = boxer2.getExtraPunchCounter();
        labelThreadCounter.setText(threadCounter + ". menet");
        threadCounter++;
        sb = new StringBuilder();
        if (!boxMatch.isGameOver()) {
            boxMatch.boxRound();
            showBoxersState();
            showExtraPounch();
            showMediation();
            buttonGo.setText("Következő menet!");
        } else {
            buttonGo.setVisible(false);
            labelThreadCounter.setText("Vége a mérkőzésnek!");
            buttonExit.setVisible(true);
            buttonNewMatch.setVisible(true);
        }

    }

    private void showExtraPounch() {
        String used = " használta a különleges képességét!";
        if (boxer1PounchCounter != boxer1.getExtraPunchCounter()) {
            sb.append(boxer1.getName())
                .append(used)
                .append(System.lineSeparator());
        }
        if (boxer2PounchCounter != boxer2.getExtraPunchCounter()) {
            sb.append(boxer2.getName())
                .append(used)
                .append(System.lineSeparator());
        }
    }
    
    @FXML
    private void buttonExit(ActionEvent event){
        System.exit(0);
    }
    
    @FXML
    private void ButtonNewMatch(ActionEvent event){
        boxerTypeList.clear();
        mainPane.setVisible(false);
        menu.setVisible(true);
    }
}
