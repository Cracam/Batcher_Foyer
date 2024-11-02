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
      

        return coloredImage;
    }
}
//blend x2 if >1 *15 else nothing