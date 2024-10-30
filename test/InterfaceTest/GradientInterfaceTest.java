/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfaceTest;

/**
 *
 * @author LECOURT Camille
 */
import Interface.GradientInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GradientInterfaceTest extends Application {

         @Override
         public void start(Stage primaryStage) {
                  

                  GradientInterface gradientInterface = new GradientInterface();
                  Scene scene = new Scene(gradientInterface);
                  primaryStage.setTitle("Gradient Interface Test");
                  primaryStage.setScene(scene);
                  primaryStage.show();
         }

         public static void main(String[] args) {
                  launch(args);
         }
}
