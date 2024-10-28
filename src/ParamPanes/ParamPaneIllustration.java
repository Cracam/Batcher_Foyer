/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParamPanes;

import batcher_foyer.Batcher_Foyer;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ParamPaneIllustration extends ParamPane {

         private Button selectImageButton;
         private ImageView previewImageView;
         private Image selectedImage;

         public ParamPaneIllustration(String name) {
                  super(name);
                  selectImageButton = new Button("Select Image");
                  previewImageView = new ImageView();
                  VBox vbox = new VBox(selectImageButton, previewImageView);
                  getTitledPane().setContent(vbox);

                  selectImageButton.setOnAction(this::handleSelectImageButtonAction);
         }

         private void handleSelectImageButtonAction(ActionEvent event) {
                  FileChooser fileChooser = new FileChooser();
                  fileChooser.setTitle("Select Image");
                  fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
                  File selectedFile = fileChooser.showOpenDialog(selectImageButton.getScene().getWindow());
                  if (selectedFile != null) {
                           try {
                                    selectedImage = new Image(selectedFile.toURI().toString());
                                    selectImageButton.setGraphic(new ImageView(selectedImage));
                                    previewImageView.setImage(selectedImage);
                                    Path destinationPath = Path.of(Batcher_Foyer.getModuleAddress(), selectedFile.getName());
                                    Files.copy(selectedFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                    setChanged(true);
                           } catch (IOException e) {
                                    e.printStackTrace();
                           }
                  }
         }
}
