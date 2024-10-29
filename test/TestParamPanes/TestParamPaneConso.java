/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestParamPanes;
import ParamPanes.ParamPaneConso;
import static batcher_foyer.Batcher_Foyer.getResourcesPath;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TestParamPaneConso extends Application {

    @Override
    public void start(Stage stage) {
        ParamPaneConso ppc = new ParamPaneConso("Test");
        System.out.println(getResourcesPath("test.png"));
        
        File file = new File(getResourcesPath("test.png"));
         Image previewImage = new Image(file.toURI().toString());
        //Image previewImage = new Image(getResourcesPath("test.png"));
        
        ppc.setPreview(previewImage);
        stage.setScene(new Scene(ppc.getTitledPane()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
