/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock.paper.scissors.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author julian
 */
public class RockPaperScissorsGUI extends Application {
    
    private static Stage primaryStage;
    
    private void setPrimaryStage(Stage stage) {
        RockPaperScissorsGUI.primaryStage = stage;
    }
    
    public static Stage getPrimaryStage() {
        return RockPaperScissorsGUI.primaryStage;
    }    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        setPrimaryStage(stage);
        
        Parent root = FXMLLoader.load(getClass().getResource("RockPaperScissors.fxml"));
        
        Scene scene = new Scene(root);
        
        // add stylesheet to the scene
        scene.getStylesheets().add("rock/paper/scissors/gui/style.css");
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
