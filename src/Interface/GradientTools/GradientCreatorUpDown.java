package Interface.GradientTools;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class GradientCreatorUpDown extends GradientCreator {

    public GradientCreatorUpDown() {
        super("Up-Down", true,  "Angle", "Degrés", 0, 360, 1);
    }



    @Override 
   public BufferedImage generateColoredImage(BufferedImage image_in, Color color1, Color color2, double colorIntensityParam, double param1, double param2) {

             colorIntensityParam=convertBlendCoeff(colorIntensityParam);
        
         
         int x_dim=image_in.getWidth();
         int y_dim=image_in.getHeight();
         
         float [][] blendTable= new float[x_dim][y_dim];

     
//             // Loop through each pixel of the input image
//             for (int x = 0; x < x_dim; x++) {
//                      float alphaBlend = (float) Math.pow((float) x / (x_dim - 1), colorIntensityParam);
//                      for (int y = 0; y < y_dim; y++) {
//                               blendTable[y][x] = alphaBlend;
//                      }
//             }
//             
   // Loop through each pixel of the input image
// param1 is the angle in degrees
// param1 is the angle in degrees
// param1 is the angle in degrees
double angle = Math.toRadians(param1); // Convert angle to radians
double cosAngle = Math.cos(angle);
double sinAngle = Math.sin(angle);
int centerX = x_dim / 2;
int centerY = y_dim / 2;

for (int x = 0; x < x_dim; x++) {
    for (int y = 0; y < y_dim; y++) {
        // Translate the coordinates so that the center of the image becomes the origin
        int translatedX = x - centerX;
        int translatedY = y - centerY;

        // Calculate the distance of the pixel from the reference line
        double distance = Math.abs(translatedX * cosAngle + translatedY * sinAngle);

        // Calculate the color intensity based on the distance
        double intensity = Math.max(0, Math.min(1, 1 - distance / Math.sqrt(x_dim * x_dim + y_dim * y_dim)));

        blendTable[y][x] = (float) Math.pow(intensity, colorIntensityParam);
    }
}


             
         return generateImage(blendTable,color2,color1);
      
    }
}
//blend x2 if >1 *15 else nothing