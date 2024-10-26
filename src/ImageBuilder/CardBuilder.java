/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImageBuilder;

import Layers.Layer;
import java.io.File;

/**
 * The  role of this class is to build a image by piling it's differents layer
 * This calls is also in charge of initialising every layer from every types
 * @author LECOURT Camille
 */
public class CardBuilder {
        private static float Facteur_pixel_mm;
        private static int DPI;
        private static File xmlResourcesFile;
        private static String moduleAddress;
        private float size_x;
        private float size_y;
        
        private String Name;
        private Layer[] layers;

        
    public CardBuilder(String Name,float size_x, float size_y) {
        this.Name = Name;
        this.size_x = size_x;
        this.size_y = size_y;
        
    }

        


        public static void setDPI(int DPI) {
            CardBuilder.DPI = DPI;

        }

        public static float getFacteur_pixel_mm() {
            return Facteur_pixel_mm;
        }
        
    
        
      
        
        
        
}
