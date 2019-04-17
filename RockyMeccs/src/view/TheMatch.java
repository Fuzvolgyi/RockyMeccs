
package view;

import Interface.BoxerType;
import boxer.Boxer;
import boxer.BoxerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author FZs
 */
public class TheMatch extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("BoxMatchFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Boxmecs");
        stage.setResizable(false);
        
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    } 
    }
 
    
    
    
//    public static void main(String[] args) {
//        BoxerFactory boxerFactory = new BoxerFactory();
//        
//        Boxer boxer1 = boxerFactory.getBoxer(BoxerType.KEN);
//        Boxer boxer2 = boxerFactory.getBoxer(BoxerType.ROCKY);
//        
//        BoxMatch Match = new BoxMatch(boxer1, boxer2);
//        
//        Match.boxRound();
//    }

