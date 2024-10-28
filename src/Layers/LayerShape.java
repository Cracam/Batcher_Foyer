/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layers;

import batcher_foyer.Batcher_Foyer;
import java.io.File;

/**
 * This class is a layer wich a shape image(normal PNG image which we will take
 * only opacipty values) will be changed by the user of the app using the
 * interface tab "Formes"
 *
 * @author LECOURT Camille
 */
public class LayerShape extends Layer {

         private String color;

         public LayerShape(String name, float pos_x, float pos_y, float size_x, float size_y, String color) {
                  super(name, pos_x, pos_y, size_x, size_y);
                  this.color = color;
         }

         @Override
         protected void compImagePath() {
                  this.imagepath = Batcher_Foyer.getModuleAddress() + this.imagename;
         }

}
