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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
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
    AnchorPane redCorner;
    @FXML
    AnchorPane blueCorner;

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
    private ArrayList boxerList = new ArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void btStartTheMatch(ActionEvent event) {
        createBoxerList();
        if (voteIsValid()) {
            labelAlert.setText(null);
            createBoxers();
        } else {
            labelAlert.setText("Két boxolót válassz ki!");
        }
    }

    private void createBoxerList() {
        if (checkBoxRocky.isSelected()) {
            boxerList.add(BoxerType.ROCKY);
        }
        if (checkBoxKen.isSelected()) {
            boxerList.add(BoxerType.KEN);
        }
        if (checkBoxBoxer.isSelected()) {
            boxerList.add(BoxerType.BOXER);
        }
    }

    private boolean voteIsValid() {
        return boxerList.size() == 2;
    }

    private void createBoxers() {
        BoxerFactory boxerFactory = new BoxerFactory();
        boxer1 = boxerFactory.getBoxer((BoxerType) boxerList.get(0));
        boxer2 = boxerFactory.getBoxer((BoxerType) boxerList.get(1));
    }

}
