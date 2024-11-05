package Interface;

import Exceptions.ResourcesFileErrorException;
import Interface.GradientTools.GradientCreator;
import Interface.GradientTools.GradientCreatorInterface;
import Interface.GradientTools.GradientCreatorLeftRight;
import Interface.GradientTools.GradientCreatorUpDown;
import Interface.GradientTools.GradientMonocolor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class ImageLoaderInterface extends VBox{

    @FXML
    private Button ImageLoaderButton;

    private ImageView preview;


    
    
    public ImageLoaderInterface(){
             try {
                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ImageLoaderInterface.fxml"));
                           if (fxmlLoader == null) {
                                    throw new ResourcesFileErrorException();
                           }
                           fxmlLoader.setRoot(this);
                           fxmlLoader.setController(this);

                           fxmlLoader.load();

                         preview=(ImageView) ImageLoaderButton.getGraphic();
                          

                  } catch (IOException | ResourcesFileErrorException | IllegalArgumentException  ex) {
                           Logger.getLogger(GradientCreatorInterface.class.getName()).log(Level.SEVERE, null, ex);
                  }
    }

    @FXML
    private void loaderClicked() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(ImageLoaderButton.getScene().getWindow());
        if (selectedFile != null) {
            preview.setImage(new Image("file:" + selectedFile.getAbsolutePath()));
        }
    }

    @FXML
    private void dargdetected(DragEvent event) {
        Dragboard db = ImageLoaderButton.startDragAndDrop(TransferMode.ANY);
        db.setDragView(preview.getImage());
        event.consume();
    }

    @FXML
    private void dragDone(DragEvent event) {
        event.consume();
    }

    @FXML
    private void dragDropped(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            String filePath = null;
            for (File file : db.getFiles()) {
                filePath = file.getAbsolutePath();
                if (filePath.endsWith(".png") || filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
                    preview.setImage(new Image("file:" + filePath));
                    break;
                }
            }
        }
        event.setDropCompleted(success);
        event.consume();
    }
}
