/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortressofdoomfx;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Aosys
 */
public class FortressOfDoomFX extends Application {
    
    private Stage stage = null;
    private AnchorPane gamescreen;
    
    @Override
    public void start(Stage primaryStage) {
        
        //This sets the primary stage of the application
        stage = primaryStage;
        StackPane root = new StackPane();
        
        //Calls the showGamescreen method in this class
        this.showGamescreen();
        
    }
    
    public void showGamescreen() {
        try {
            // Load the gamescreen
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FortressOfDoomFX.class.getResource("view/GameScreen.fxml"));
            AnchorPane game = (AnchorPane) loader.load();
            
            Scene scene = new Scene(game);
            //Sets the title of the "JFrame"
            stage.setTitle("Fortress of Doom");
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}