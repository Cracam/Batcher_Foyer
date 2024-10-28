/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParamPanes;

import batcher_foyer.Batcher_Foyer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class ParamPaneConso extends ParamPane {
    private final Button selectImageButton;
    private final ImageView previewImageView;
    private Image selectedImage;
    private final Button addItemButton;
    private final Accordion itemsAccordion;
    private final List<TitledPane> itemPanes;

    public ParamPaneConso(String name) {
        super(name);
        selectImageButton = new Button("Select Image");
        previewImageView = new ImageView();
        addItemButton = new Button("Add Item");
        itemsAccordion = new Accordion();
        itemPanes = new ArrayList<>();
        VBox vbox = new VBox(selectImageButton, previewImageView, addItemButton, itemsAccordion);
        getTitledPane().setContent(vbox);

        selectImageButton.setOnAction(this::handleSelectImageButtonAction);
        addItemButton.setOnAction(this::handleAddItemButtonAction);
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

    private void handleAddItemButtonAction(ActionEvent event) {
        TitledPane itemPane = createItemPane();
        itemsAccordion.getPanes().add(itemPane);
        itemPanes.add(itemPane);
        setChanged(true);
    }

    private TitledPane createItemPane() {
        ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        Label numberLabel = new Label("Nombre de:");
        TextField numberTextField = new TextField();
        numberTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setChanged(true);
            }
        });
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> {
            itemsAccordion.getPanes().remove(deleteButton.getParent());
            itemPanes.remove(deleteButton.getParent());
            setChanged(true);
        });
        HBox hbox = new HBox(colorPicker, numberLabel, numberTextField, deleteButton);
        TitledPane itemPane = new TitledPane("Item", hbox);
        return itemPane;
    }


}

