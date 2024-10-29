/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParamPanes;

import batcher_foyer.Batcher_Foyer;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ParamPaneDecoration extends ParamPane {
    private final Button selectImageButton;
    
    private final ColorPicker colorPicker;
    private Image selectedImage;

    /**
     * Constructs a new ParamPaneDecoration object with the specified name.
     *
     * @param name the name of the ParamPaneDecoration object
     */
    public ParamPaneDecoration(String name) {
        super(name);
        selectImageButton = new Button("Select Image");
        preview = new ImageView();
        colorPicker = new ColorPicker(Color.GREEN);
        VBox vbox = new VBox(selectImageButton, preview, colorPicker);
        getTitledPane().setContent(vbox);

        selectImageButton.setOnAction(this::handleSelectImageButtonAction);
        colorPicker.setOnAction(this::handleColorPickerAction);
    }

    /**
     * Handles the action event when the select image button is clicked.
     * Opens a file chooser dialog to allow the user to select an image file.
     * If the user selects a file, converts the selected image to a monocolor image using the specified color,
     * saves the monocolor image to the module folder, sets the monocolor image as the graphic for the select image button,
     * and sets the preview image view to display the monocolor image.
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
                selectedImage = ParamPane.convertToMonocolor(selectedImage);
                selectImageButton.setGraphic(new ImageView(selectedImage));
                preview.setImage(selectedImage);
                Path destinationPath = Path.of(Batcher_Foyer.getModuleAddress(), selectedFile.getName());
                saveImage(selectedImage, destinationPath.toString());
                setChanged(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Handles the action event when the color picker is used to select a new color.
     * If a selected image is already loaded, converts the selected image to a monocolor image using the new color,
     * sets the monocolor image as the graphic for the select image button,
     * and sets the preview image view to display the monocolor image.
     * Also sets the changed flag to true.
     *
     * @param event the action event that triggered this method
     */
    private void handleColorPickerAction(ActionEvent event) {
        if (selectedImage != null) {
            selectedImage = ParamPane.convertToMonocolor(selectedImage);
            selectImageButton.setGraphic(new ImageView(selectedImage));
            preview.setImage(selectedImage);
            setChanged(true);
        }
    }



    /**
     * Saves the specified image to the specified file path in PNG format.
     *
     * @param image the image to save
     * @param filePath the file path to save the image to
     * @throws IOException if an error occurs while saving the image
     */
    private void saveImage(Image image, String filePath) throws IOException {
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        File outputFile = new File(filePath);
        ImageIO.write(bufferedImage, "png", outputFile);
    }
    
     @Override
         public void setPreview(Image previewImage) {
                  this.preview = new ImageView(previewImage);
         }
}

