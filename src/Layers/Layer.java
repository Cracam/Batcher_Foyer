/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layers;

import javafx.scene.image.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
/**
 *
 * @author LECOURT Camille
 */
public abstract class Layer {

         private String name;

         float pos_x;
         float pos_y;
         float size_x;
         float size_y;

         String imagename;
         String imagepath;
         BufferedImage image_out;
         BufferedImage image_in;

         public Layer(String name, float pos_x, float pos_y, float size_x, float size_y) {
                  this.name = name;
                  this.pos_x = pos_x;
                  this.pos_y = pos_y;
                  this.size_x = size_x;
                  this.size_y = size_y;
         }

         public Layer(String name, float pos_x, float pos_y, float size_x, float size_y, String imagename) {
                  this.name = name;
                  this.pos_x = pos_x;
                  this.pos_y = pos_y;
                  this.size_x = size_x;
                  this.size_y = size_y;
                  this.imagename = imagename;
         }

         public void loadImageIn() {
                  try {
                           System.out.println("Paths " +this.imagepath);
                           this.image_in = ImageIO.read(new File(this.imagepath));
                  } catch (IOException e) {
                           System.err.println("Error loading image: " + e.getMessage());
                  }
         }


         public void setImagename(String imagename) {
                  this.imagename = imagename;
         }

         public String getName() {
                  return name;
         }

         
      
          
           protected abstract void compImagePath();
      

         public BufferedImage getBufferedImage() {
                 return this.image_in;
         }
         public Image getImage() {
                  //return  Toolkit.getDefaultToolkit().createImage( this.image_in.getSource());
                    return SwingFXUtils.toFXImage(this.image_in, null);

         }
         
}
