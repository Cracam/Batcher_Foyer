/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.GradientTools;

import java.awt.image.BufferedImage;
import javafx.scene.image.Image;

/**
 *
 * @author LECOURT Camille
 */
public abstract class Gradient {
         private final String name;
         //private final Image previewImage; if custom cmbobox implementation
         
         private final boolean slideBar1Used;
         private final String Slibar1_name;
         private final String Slidebar1_unit;

       private final boolean slideBar2Used;
         private final String Slibar2_name;
         private final String Slidebar2_unit;

         public Gradient(String name, boolean slideBar1Used, String Slibar1_name, String Slidebar1_unit, boolean slideBar2Used, String Slibar2_name, String Slidebar2_unit) {
                  this.name = name;
                  this.slideBar1Used = slideBar1Used;
                  this.Slibar1_name = Slibar1_name;
                  this.Slidebar1_unit = Slidebar1_unit;
                  this.slideBar2Used = slideBar2Used;
                  this.Slibar2_name = Slibar2_name;
                  this.Slidebar2_unit = Slidebar2_unit;
         }

         public String getName() {
                  return name;
         }

         public boolean isSlideBar1Used() {
                  return slideBar1Used;
         }

         public boolean isSlideBar2Used() {
                  return slideBar2Used;
         }

         public String getSlibar1_name() {
                  return Slibar1_name;
         }

         public String getSlidebar1_unit() {
                  return Slidebar1_unit;
         }

         public String getSlibar2_name() {
                  return Slibar2_name;
         }

         public String getSlidebar2_unit() {
                  return Slidebar2_unit;
         }
         
         
         public abstract Image generatePreview();
         public abstract BufferedImage generateColoredImage();
         
}
