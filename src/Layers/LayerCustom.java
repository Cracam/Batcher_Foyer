
package Layers;

import batcher_foyer.Batcher_Foyer;


/**
 * This layer image will be frealy set by the user of the app
 *
 * @author LECOURT Camille
 */
public class LayerCustom extends Layer {

         public LayerCustom(String name, float pos_x, float pos_y, float size_x, float size_y) {
                  super(name, pos_x, pos_y, size_x, size_y);
         }



          @Override
         protected void compImagePath() {
                  this.imagepath = Batcher_Foyer.getModulePath(this.imagename);
         }
}
