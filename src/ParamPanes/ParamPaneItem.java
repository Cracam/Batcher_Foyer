
package ParamPanes;

import batcher_foyer.Batcher_Foyer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import java.util.ArrayList;
import java.util.List;

public class ParamPaneItem extends ParamPane {

         private Button addItemButton;
         private Accordion itemsAccordion;
         private List<TitledPane> itemPanes;
         private boolean changed;

         public ParamPaneItem(String name) {
                  super(name);
                  addItemButton = new Button("Add Item");
                  itemsAccordion = new Accordion();
                  itemPanes = new ArrayList<>();
                  VBox vbox = new VBox(addItemButton, itemsAccordion,preview);
                  getTitledPane().setContent(vbox);

                  addItemButton.setOnAction(this::handleAddItemButtonAction);
         }

         private void handleAddItemButtonAction(ActionEvent event) {
                  TitledPane itemPane = createItemPane();
                  itemsAccordion.getPanes().add(itemPane);
                  itemPanes.add(itemPane);
                  changed = true;
         }

         private TitledPane createItemPane() {
                  Button selectImageButton = new Button("Select Image");
                  ImageView previewImageView = new ImageView();
                  selectImageButton.setOnAction(event -> {
                           FileChooser fileChooser = new FileChooser();
                           fileChooser.setTitle("Select Image");
                           fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
                           File selectedFile = fileChooser.showOpenDialog(selectImageButton.getScene().getWindow());
                           if (selectedFile != null) {
                                    try {
                                             Image selectedImage = new Image(selectedFile.toURI().toString());
                                             selectImageButton.setGraphic(new ImageView(selectedImage));
                                             previewImageView.setImage(selectedImage);
                                             Path destinationPath = Path.of(Batcher_Foyer.getModuleAddress(), selectedFile.getName());
                                             Files.copy(selectedFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                             setChanged(true);
                                    } catch (IOException e) {
                                             e.printStackTrace();
                                    }
                           }
                  });
                  Label numberLabel = new Label("Nombre de:");
                  TextField numberTextField = new TextField();
                  numberTextField.textProperty().addListener(new ChangeListener<String>() {
                           @Override
                           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                                    setChanged(true);
                           }
                  });
                  Label opacityLabel = new Label("Opacité de l'item:");
                  TextField opacityTextField = new TextField();
                  opacityTextField.textProperty().addListener(new ChangeListener<String>() {
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
                  VBox vbox = new VBox(selectImageButton, previewImageView, numberLabel, numberTextField, opacityLabel, opacityTextField, deleteButton);
                  TitledPane itemPane = new TitledPane("Item", vbox);
                  return itemPane;
         }

         @Override
         public void setPreview(Image preview) {
                  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         }

}
