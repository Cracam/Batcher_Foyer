/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package batcher_foyer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author LECOURT Camille
 */
public class Batcher_Foyer extends Application{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {
   
        
        
        Parent root =FXMLLoader.load(getClass().getClassLoader().getResource("InterfaceBatcher.fxml"));
        primarystage.setTitle("hello");
        primarystage.setScene(new Scene(root));
        primarystage.show();
        
    }
    
}
