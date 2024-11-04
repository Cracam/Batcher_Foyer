package Interface.GradientTools;

import java.awt.image.BufferedImage;
import javafx.scene.image.Image;
import java.awt.Color;
import java.awt.Graphics2D;
import javafx.embed.swing.SwingFXUtils;

/**
 * This class is used to create gradient and his preview it will also comunicate
 the name, max lenght, unit with the GradientCreator Picker interface
 *
 * @author LECOURT Camille
 */
public abstract class GradientCreator {

         private final String name;
         //private final Image previewImage; if custom cmbobox implementation

         private final boolean use2color;
         
         private final boolean slideBar1Used;
         private final String slibar1_name;
         private final String slidebar1_unit;
         private final int slidebar1_min;
         private final int slidebar1_max;

         private final boolean slideBar2Used;
         private final String slibar2_name;
         private final String slidebar2_unit;
         private final int slidebar2_min;
         private final int slidebar2_max;
         
         private static final float maxBlend=(float) 15.0;
         
         public GradientCreator(String name, boolean use2color, boolean slideBar1Used, String slibar1_name, String slidebar1_unit, int slidebar1_min, int slidebar1_max, boolean slideBar2Used, String slibar2_name, String slidebar2_unit, int slidebar2_min, int slidebar2_max) {
                  this.name = name;
                  this.use2color = use2color;
                  this.slideBar1Used = slideBar1Used;
                  this.slibar1_name = slibar1_name;
                  this.slidebar1_unit = slidebar1_unit;
                  this.slidebar1_min = slidebar1_min;
                  this.slidebar1_max = slidebar1_max;
                  this.slideBar2Used = slideBar2Used;
                  this.slibar2_name = slibar2_name;
                  this.slidebar2_unit = slidebar2_unit;
                  this.slidebar2_min = slidebar2_min;
                  this.slidebar2_max = slidebar2_max;
         }

         public static float getMaxBlend() {
                  return maxBlend;
         }

        

         public int getSlidebar1_min() {
                  return slidebar1_min;
         }

         public int getSlidebar1_max() {
                  return slidebar1_max;
         }

         public int getSlidebar2_min() {
                  return slidebar2_min;
         }

         public int getSlidebar2_max() {
                  return slidebar2_max;
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
                  return slibar1_name;
         }

         public String getSlidebar1_unit() {
                  return slidebar1_unit;
         }

         public String getSlibar2_name() {
                  return slibar2_name;
         }

         public String getSlidebar2_unit() {
                  return slidebar2_unit;
         }

         public boolean isUse2color() {
                  return use2color;
         }

         
         
public Image generatePreview(Color color1, Color color2, double colorIntensityParam, double param1, double param2) {
    BufferedImage previewImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = previewImage.createGraphics();
    g2d.fillRect(0, 0, 100, 100);
    g2d.dispose();

    BufferedImage coloredImage = generateColoredImage(previewImage, color1, color2, colorIntensityParam, param1, param2);

    return SwingFXUtils.toFXImage(coloredImage, null);
}

/**
 * return the value of the blend coefficent and the color order if necessary
 * @return 
 */
 Object[] convertBlendCoeff(double colorIntensityParam,Color color1, Color color2){
                  Object[] ret = new Object[3];
                  System.out.println(colorIntensityParam);
                 float  invMaxBlend=1/maxBlend;

          
          if( colorIntensityParam<0.5){
                   ret[0]=(1-invMaxBlend)*2*colorIntensityParam+invMaxBlend ; 
                   ret[1]=color1;
                   ret[2]=color2;
                   return ret;
          }
          
           ret[0]=(maxBlend-1)*2*colorIntensityParam+2-maxBlend;
           System.out.println("RET"+ret[0]);
                   ret[1]=color1;
                   ret[2]=color2;
                   return ret;
           
 }


         public static BufferedImage generateImage(float[][] table, Color color1, Color color2) {
                  int width = table.length;
                  int height = table[0].length;
                  BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

                  for (int i = 0; i < width; i++) {
                           for (int j = 0; j < height; j++) {
                                    float value = table[i][j];
                                    int red = (int) (color1.getRed() * value + color2.getRed() * (1 - value));
                                    int green = (int) (color1.getGreen() * value + color2.getGreen() * (1 - value));
                                    int blue = (int) (color1.getBlue() * value + color2.getBlue() * (1 - value));
                                    int alpha = (int) (color1.getAlpha() * value + color2.getAlpha() * (1 - value));
                                    int rgba = (alpha << 24) | (red << 16) | (green << 8) | blue;
                                    image.setRGB(i, j, rgba);
                           }
                  }

                  return image;
         }

  
  
  
  
 public abstract BufferedImage generateColoredImage(BufferedImage image_in, Color color1 , Color color2, double colorIntensityParam, double param1, double param2 );
         
//         public abstract GradientCreator();
}
