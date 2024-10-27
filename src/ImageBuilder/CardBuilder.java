/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImageBuilder;

import Layers.Layer;
import Layers.LayerColor;
import Layers.LayerConsosBuilder;
import Layers.LayerCustom;
import Layers.LayerFixed;
import Layers.LayerItemsBuilder;
import Layers.LayerShape;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * The role of this class is to build a image by piling it's differents layer
 * This calls is also in charge of initialising every layer from every types
 *
 * @author LECOURT Camille
 */
public class CardBuilder {

         private static float Factor_pixel_mm;
         private static int DPI;
         private static String moduleAddress;
         private final float size_x;
         private final float size_y;

         private final String Name;
         private Layer[] layers;

         public CardBuilder(String Name, float size_x, float size_y) {
                  this.Name = Name;
                  this.size_x = size_x;
                  this.size_y = size_y;
         }
         
         /**
          * This function will set the DPI (Dot Per Inch) of our image 
          * We will compute The Factor_pixel_mm value using inch to milimeter convertion
          * @param DPI 
          */
         public static void setDPI(int DPI) {
                  CardBuilder.DPI = DPI;
                  CardBuilder.Factor_pixel_mm = (float) (DPI / 24.5);
         }

         public static float getFacteur_pixel_mm() {
                  return Factor_pixel_mm;
         }

         
         
         
         
         
         
         /**
          * This function will create all the Layers of the iamge passed by the XML file 
          * @param LayersList the list of all node element nessesary for the layer creation 
          */
         public void setLayers(List<Node> LayersList) {
                  this.layers = new Layer[LayersList.size()];
                  int i = 0;
                  for (Node node : LayersList) {
                           if (node.getNodeType() == Node.ELEMENT_NODE) {
                                    Element element = (Element) node;
                                    String nodeName = element.getNodeName();
                                    String name = element.getAttribute("name");
                                    String pngName = element.getAttribute("png_name");
                                    float posX = Float.parseFloat(element.getElementsByTagName("pos").item(0).getAttributes().getNamedItem("pos_x").getNodeValue());
                                    float posY = Float.parseFloat(element.getElementsByTagName("pos").item(0).getAttributes().getNamedItem("pos_y").getNodeValue());
                                    float sizeX = Float.parseFloat(element.getElementsByTagName("size").item(0).getAttributes().getNamedItem("size_x").getNodeValue());
                                    float sizeY = Float.parseFloat(element.getElementsByTagName("size").item(0).getAttributes().getNamedItem("size_y").getNodeValue());

                                    if (nodeName.equals("img_fixe")) {
                                             layers[i] = new LayerFixed(name, posX, posY, sizeX, sizeY, pngName);
                                    } else if (nodeName.equals("img_color")) {
                                             layers[i] = new LayerColor(name, posX, posY, sizeX, sizeY, pngName);

                                    } else if (nodeName.equals("img_custom")) {
                                             layers[i] = new LayerCustom(name, posX, posY, sizeX, sizeY);

                                    } else if (nodeName.equals("img_custom_shape")) {
                                             layers[i] = new LayerShape(name, posX, posY, sizeX, sizeY);

                                    } else if (nodeName.equals("img_Consos")) {
                                             layers[i] = new LayerConsosBuilder(name, posX, posY, sizeX, sizeY);

                                    } else if (nodeName.equals("img_Items")) {
                                             layers[i] = new LayerItemsBuilder(name, posX, posY, sizeX, sizeY);

                                    }

                                    i++;
                           }
                  }

         }

}
