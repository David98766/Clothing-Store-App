/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package javafxproject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author adamm
 */
public class JavaFXProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        stage.onCloseRequestProperty().setValue(e -> Platform.exit());
        
        
       Parent root = FXMLLoader.load(getClass().getResource("/javafxproject/FXMLDocument.fxml"));
        
        Scene LoginScene = new Scene(root);
        stage.setTitle("Forever 22 Login");
        stage.setScene(LoginScene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
