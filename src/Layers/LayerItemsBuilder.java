/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layers;

import batcher_foyer.Batcher_Foyer;

/**
 *
 * @author LECOURT Camille
 */
public class LayerItemsBuilder extends Layer {

         private float consSize_x;
         private float consSize_y;

         public LayerItemsBuilder(String name, float pos_x, float pos_y, float size_x, float size_y, float consSize_x, float consSize_y) {
                  super(name, pos_x, pos_y, size_x, size_y);
                  this.consSize_x = consSize_x;
                  this.consSize_y = consSize_y;
         }
         
@Override
         protected void compImagePath() {
                  this.imagepath = Batcher_Foyer.getModulePath(this.imagename);
         }


   
    
    
          
}
