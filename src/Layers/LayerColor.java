/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layers;
import batcher_foyer.Batcher_Foyer;
          
/**
 * This class is a layer wich is color will be changed by the user of the app using the interface tab "Couleurs"
 * @author LECOURT Camille
 */
public class LayerColor extends Layer{
         private String colorID;
         private String color;
 
    public LayerColor(String name, float pos_x, float pos_y, float size_x, float size_y, String imagename ,String colorID) {
        super(name, pos_x, pos_y, size_x, size_y, imagename);
        this.colorID=colorID;
    }

         @Override
         protected void loadImage() {
                  compImagePath();
                  this.image_in=
         }
    
    

    
    
    
         protected void compImagePath() {
                  this.imagepath = Batcher_Foyer.getResourcesPath(this.imagename);
         }
}
