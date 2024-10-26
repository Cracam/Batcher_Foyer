/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImageBuilder;

import java.io.File;

/**
 * The  role of this class is to build a image by piling it's differents layer
 * This calls is also in charge of initialising every layer from every types
 * @author LECOURT Camille
 */
public class ImageBuilder {
        private static float Facteur_pixel_mm;
        private static int DPI;
        private static File xmlResourcesFile;
        private static String moduleAddress;
        
        
        private String Name;
        private Layer[] layers;

        public ImageBuilder(String Name) {
            this.Name = Name;
        }

        public static void setDPI(int DPI) {
            ImageBuilder.DPI = DPI;

        }

        public static float getFacteur_pixel_mm() {
            return Facteur_pixel_mm;
        }
        
    
        
      
        
        
        
}
