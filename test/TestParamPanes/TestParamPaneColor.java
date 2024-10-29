package TestParamPanes;


import ParamPanes.ParamPaneColor;
import static batcher_foyer.Batcher_Foyer.getResourcesPath;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TestParamPaneColor extends Application {

    @Override
    public void start(Stage stage) {
        ParamPaneColor ppc = new ParamPaneColor("Test");
        
         File file = new File(getResourcesPath("test.png"));
         Image previewImage = new Image(file.toURI().toString());
        ppc.setPreview(previewImage);
        stage.setScene(new Scene(ppc.getTitledPane()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
