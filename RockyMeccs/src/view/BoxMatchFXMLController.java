/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Interface.BoxerType;
import boxer.Boxer;
import boxer.BoxerFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
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

    private Boxer boxer1;
    private Boxer boxer2;
    private ArrayList boxerTypeList = new ArrayList();
    private Random rd = new Random();

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
    }

    
    
    private void showBoxersState() {
        tfRedName.setText(boxer1.getName());
        tfRedStrength.setText(String.valueOf(boxer1.getStrength()));
        tfRedPunchPower.setText(String.valueOf(boxer1.getPunchPower()));
        
        tfBlueName.setText(boxer2.getName());
        tfBlueStrength.setText(String.valueOf(boxer2.getStrength()));
        tfBluePunchPower.setText(String.valueOf(boxer2.getPunchPower()));
   }

}
