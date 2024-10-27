/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author LECOURT Camille
 */
public class Layer {
        private String name;

   
        private float pos_x;
        private float pos_y;
        private float size_x;
        private float size_y;
        
        private String imagename;
        private String imagepath;
        private BufferedImage image_out;
        private BufferedImage image_in;

        
        
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

        

         private loadImageIn() {
                  try {
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
        
        public void LoadImage(){
            
        }
        
}
