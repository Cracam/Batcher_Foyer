package Interface.GradientTools;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class GradientCreatorUpDown extends GradientCreator {

    public GradientCreatorUpDown() {
        super("Up-Down", true, true, "Angle", "Degrees", 0, 360, false, "", "", 0, 0);
    }



    @Override 
   public BufferedImage generateColoredImage(BufferedImage image_in, Color color1, Color color2, double colorIntensityParam, double param1, double param2) {

            Object[] temp= convertBlendCoeff(colorIntensityParam,color1,color2);
         colorIntensityParam=(double) temp[0];
         color1=(Color) temp[1];
         color2=(Color) temp[2];
         
         int x_dim=image_in.getWidth();
         int y_dim=image_in.getHeight();
         
         float [][] blendTable= new float[x_dim][y_dim];

     
             // Loop through each pixel of the input image
             for (int x = 0; x < x_dim; x++) {
                      float alphaBlend = (float) Math.pow((float) x / (x_dim - 1), colorIntensityParam);
                      for (int y = 0; y < y_dim; y++) {
                               blendTable[y][x] = alphaBlend;
                      }
             }
             
         return generateImage(blendTable,color1,color2);
      
    }
}
//blend x2 if >1 *15 else nothing