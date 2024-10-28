/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParamPanes;

/**
 *
 * @author LECOURT Camille
 */
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;

public abstract class ParamPane {

         private final TitledPane titledPane;
         private final String name;
         boolean changed;

         public ParamPane(String name) {
                  this.name = name;
                  this.changed = false;
                  this.titledPane = new TitledPane(name, new Pane());
                  
         }

         public TitledPane getTitledPane() {
                  return titledPane;
         }

         public String getName() {
                  return name;
         }

         public boolean isChanged() {
                  return changed;
         }

         public void setChanged(boolean changed) {
                  this.changed = changed;
         }

     
         
         
         public void resetChanged() {
                  changed = false;
         }

         public void applyChanges(){
                          }
         
         
         
         
            /**
     * Converts the specified image to a monocolor image (green with RGB values of 0, 255, 0)
     * while keeping its opacity values.
     *
     * @param image the image to convert to monocolor
     * @return a new WritableImage object that is a monocolor version of the input image
     */
    static  Image convertToMonocolor(Image image) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        PixelReader reader = image.getPixelReader();
        WritableImage writableImage = new WritableImage(width, height);
        PixelWriter writer = writableImage.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int argb = reader.getArgb(x, y);
                int alpha = (argb >> 24) & 0xff;
                int green = (alpha << 24) | 0x00ff00;
                writer.setArgb(x, y, green);
            }
        }
        return writableImage;
    }
}
