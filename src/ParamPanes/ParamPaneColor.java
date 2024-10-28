/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParamPanes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author LECOURT Camille
 */
public class ParamPaneColor extends ParamPane {

         private final ColorPicker colorPicker;
         private ImageView preview;

         public ParamPaneColor(String name) {
                  super(name);
                  colorPicker = new ColorPicker();
                  preview = new ImageView();

                  VBox vbox = new VBox(colorPicker, preview);
                  getTitledPane().setContent(vbox);

                  this.getTitledPane().expandedProperty().addListener(new ChangeListener<Boolean>() {
                           @Override
                           public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                                    setChanged(true);
                           }

                  });
         }

         public Color getColor() {
                  return colorPicker.getValue();
         }

         public void setColor(Color color) {
                  colorPicker.setValue(color);
         }

         public ImageView getPreview() {
                  return preview;
         }

         public void setPreview(ImageView preview) {
                  this.preview = preview;
         }



}
