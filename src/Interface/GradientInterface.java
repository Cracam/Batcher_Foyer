package Interface;

import Exceptions.ResourcesFileErrorException;
import batcher_foyer.Batcher_Foyer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;

public class GradientInterface extends HBox {

     private float pixel_mm_Factor;
     
     private static ImageView hideImageView;
     private  ImageView showImageView;
     
     
  
    @FXML
    private Button ToogleButton;

    @FXML
    private HBox ToggleableHbox;

    @FXML
    private ComboBox<String> ListGradient;

    @FXML
    private Slider SlideBarColorIntensity;

    @FXML
    private ColorPicker ColorPicker1;

    @FXML
    private ColorPicker ColorPicker2;

    @FXML
    private Label LabelParam1;

    @FXML
    private Slider SlideBarParam1;

    @FXML
    private Label LabelParam2;

    @FXML
    private Slider SlideBarParam2;

    @FXML
    private ImageView preview;

    public GradientInterface() {
              try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GradientPicker.fxml"));
                       if (fxmlLoader==null){
                                throw new ResourcesFileErrorException();
                       }
                     fxmlLoader.setRoot(this);
                      fxmlLoader.setController(this);
                       
                       fxmlLoader.load();

                       
                       hideImageView = new ImageView(new Image(getClass().getResource("/hide.png").toExternalForm()));
                       hideImageView.setFitHeight(15.0);
                       hideImageView.setFitWidth(15.0);
                       ToogleButton.setGraphic(hideImageView);
                       
                       showImageView = new ImageView();
              } catch (IOException |ResourcesFileErrorException ex) {
                       Logger.getLogger(GradientInterface.class.getName()).log(Level.SEVERE, null, ex);
              }


         }

         @FXML
         private void ToggleHideShow() {
                      System.out.println("ToggleHideShow event handler triggered.");

                  if (ToggleableHbox.isVisible()) {
                           ToggleableHbox.setVisible(false);
                           ToggleableHbox.setPrefSize(0, 0);
      
                           // set preview image to our button
                           showImageView.setImage(preview.getImage());
                           showImageView.setFitWidth(60);
                           showImageView.setFitHeight(60);
                           
                           ToogleButton.setGraphic(showImageView);
                  } else {
                           ToggleableHbox.setVisible(true);
                           ToggleableHbox.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                           ToogleButton.setGraphic(hideImageView);
                  }
         }

         public void setPixel_mm_Factor(float pixel_mm_Factor) {
                  this.pixel_mm_Factor = pixel_mm_Factor;
         }


    @FXML
    private void UpdateGradient() {
             System.out.println("UpdateGradient event handler triggered.");
        // TODO: Implement the gradient update logic
    }

    @FXML
    private void UpdateBar1() {
        // TODO: Implement the parameter 1 update logic
        System.out.println("UpdateBar1 event handler triggered.");
        
        
        
        
      this.UpdateGradient();
    }

    @FXML
    private void UpdateBar2() {
        // TODO: Implement the parameter 2 update logic
        System.out.println("UpdateBar2 event handler triggered.");
     this.UpdateGradient();
    }
}


