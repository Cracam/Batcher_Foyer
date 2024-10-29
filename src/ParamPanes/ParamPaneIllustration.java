/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParamPanes;

import batcher_foyer.Batcher_Foyer;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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
    private final Button selectImageButton;
    private Image selectedImage;

    /**
     * Constructs a new ParamPaneIllustration object with the specified name.
     *
     * @param name the name of the ParamPaneIllustration object
     */
    public ParamPaneIllustration(String name) {
        super(name);
        selectImageButton = new Button("Select Image");
        preview = new ImageView();
        VBox vbox = new VBox(selectImageButton, preview);
        getTitledPane().setContent(vbox);

        selectImageButton.setOnAction(this::handleSelectImageButtonAction);
    }

    /**
     * Handles the action event when the select image button is clicked.
     * Opens a file chooser dialog to allow the user to select an image file.
     * If the user selects a file, copies the file to the module folder,
     * sets the selected image as the graphic for the select image button,
     * and sets the preview image view to display the selected image.
     * Also sets the changed flag to true.
     *
     * @param event the action event that triggered this method
     */
    private void handleSelectImageButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(selectImageButton.getScene().getWindow());
        if (selectedFile != null) {
            try {
                selectedImage = new Image(selectedFile.toURI().toString());
                selectImageButton.setGraphic(new ImageView(selectedImage));
                preview.setImage(selectedImage);
                Path destinationPath = Path.of(Batcher_Foyer.getModuleAddress(), selectedFile.getName());
                Files.copy(selectedFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                setChanged(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

         @Override
         public void setPreview(Image preview) {
                  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         }
}

