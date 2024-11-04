package Interface.GradientTools;

import Exceptions.ResourcesFileErrorException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.scene.Cursor;

public class GradientCreatorInterface extends HBox {

     
     private static ImageView hideImageView;
     private  ImageView showImageView;
     
     private static final boolean allowOpacity=false;
  
    @FXML
    private Button ToogleButton;

    @FXML
    private HBox ToggleableHbox;

    @FXML
    private ComboBox<String> ListGradient;
private Map<String, GradientCreator> gradientMap;
    
    @FXML
    private Slider SlideBarColorIntensity;

    @FXML
    private ColorPicker ColorPicker1;

    @FXML
    private ColorPicker ColorPicker2;

    @FXML
    private Label LabelParam1;

    @FXML
    private Slider SlideBarParam1;

    @FXML
    private Label LabelParam2;

    @FXML
    private Slider SlideBarParam2;

    @FXML
    private ImageView preview;

    public GradientCreatorInterface()  {
              try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GradientPicker.fxml"));
                       if (fxmlLoader==null){
                                throw new ResourcesFileErrorException();
                       }
                     fxmlLoader.setRoot(this);
                      fxmlLoader.setController(this);
                       
                       fxmlLoader.load();

                       
                       hideImageView = new ImageView(new Image(getClass().getResource("/hide.png").toExternalForm()));
                       hideImageView.setFitHeight(15.0);
                       hideImageView.setFitWidth(15.0);
                       ToogleButton.setGraphic(hideImageView);
                       
                       showImageView = new ImageView();
                       
                       
                       
                       // Create a dictionary of the GradientCreator class
                       gradientMap = new HashMap<>();
                       Set<Class<? extends GradientCreator>> gradientClasses = Stream.of(GradientMonocolor.class , GradientCreatorUpDown.class/* add more gradient classes here */)
                                 .collect(Collectors.toSet());
                       for (Class<? extends GradientCreator> gradientClass : gradientClasses) {
                                GradientCreator gradient = gradientClass.getDeclaredConstructor().newInstance();
                                gradientMap.put(gradient.getName(), gradient);
                       }

                       // Fill the ListGradient ComboBox
                       ListGradient.getItems().addAll(gradientMap.keySet());

                       SlideBarColorIntensity.setMin(0);
                       SlideBarColorIntensity.setMax(0.99);
                       SlideBarColorIntensity.setValue(0.5);
                       
                     ListGradient.setValue(ListGradient.getItems().get(0));
                     UpdateCombobox();
                       
              } catch (IOException |ResourcesFileErrorException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                       Logger.getLogger(GradientCreatorInterface.class.getName()).log(Level.SEVERE, null, ex);
              }


         }

    
     

    
    
    
    
    
    
    
    
         @FXML
         private void ToggleHideShow() {
                      System.out.println("ToggleHideShow event handler triggered.");

                  if (ToggleableHbox.isVisible()) {
                           ToggleableHbox.setVisible(false);
                           ToggleableHbox.setPrefSize(0, 0);
      
                           // set preview image to our button
                           showImageView.setImage(preview.getImage());
                           showImageView.setFitWidth(60);
                           showImageView.setFitHeight(60);
                           
                           ToogleButton.setGraphic(showImageView);
                  } else {
                           ToggleableHbox.setVisible(true);
                           ToggleableHbox.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                           ToogleButton.setGraphic(hideImageView);
                  }
         }

  


 @FXML
private void UpdateGradient() {
    System.out.println("UpdateGradient event handler triggered.");

    String selectedGradientName = getComboboxValue();
    GradientCreator selectedGradient = gradientMap.get(selectedGradientName);

    Color color1 = getColor1();
    Color color2 = getColor2();
    double colorIntensity = getColorIntensity();
    double param1 = getParam1();
    double param2 = getParam2();

    Image previewImage = selectedGradient.generatePreview(color1, color2, colorIntensity, param1, param2);
    preview.setImage(previewImage);
}


    @FXML
    private void UpdateBar1() {
        // TODO: Implement the parameter 1 update logic
//        
//        
//        
//        
      this.UpdateGradient();
    }

    @FXML
    private void UpdateBar2() {
     
//             
//             
//    
     this.UpdateGradient();
    }
    
    
    @FXML
    private void updateColor1(){
             if(!allowOpacity)ColorPicker1.setValue(convertAwtColorToJavafxColor(setFullOpacity(getColor1())));
             this.UpdateGradient();
    }
    
       @FXML
    private void updateColor2(){
              if(!allowOpacity)ColorPicker2.setValue(convertAwtColorToJavafxColor(setFullOpacity(getColor2())));
             this.UpdateGradient();
    }
         
    public static Color setFullOpacity(Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), 255);
    }
    
    
    
@FXML
private void UpdateCombobox(){
    String selectedGradientName = getComboboxValue();
    GradientCreator selectedGradient = gradientMap.get(selectedGradientName);

    if (selectedGradient.isSlideBar1Used()) {
        LabelParam1.setText(selectedGradient.getSlibar1_name() + " (" + selectedGradient.getSlidebar1_unit() + ")");
        SlideBarParam1.setMin(selectedGradient.getSlidebar1_min());
        SlideBarParam1.setMax(selectedGradient.getSlidebar1_max());
        SlideBarParam1.setDisable(false);
    } else {
        LabelParam1.setText("");
        SlideBarParam1.setDisable(true);
    }

    if (selectedGradient.isSlideBar2Used()) {
        LabelParam2.setText(selectedGradient.getSlibar2_name() + " (" + selectedGradient.getSlidebar2_unit() + ")");
        SlideBarParam2.setMin(selectedGradient.getSlidebar2_min());
        SlideBarParam2.setMax(selectedGradient.getSlidebar2_max());
        SlideBarParam2.setDisable(false);
    } else {
        LabelParam2.setText("");
        SlideBarParam2.setDisable(true);
    }

    if (selectedGradient.isUse2color()) {
        ColorPicker2.setDisable(false);
        SlideBarColorIntensity.setDisable(false);
    } else {
        ColorPicker2.setDisable(true);
        SlideBarColorIntensity.setDisable(true);
    }

    this.UpdateGradient();
}

    
    
    
    
    
    public double getColorIntensity(){
             return SlideBarColorIntensity.getValue();
    }
    
    public double getParam1(){
             return SlideBarParam1.getValue();
    }
    
    public double getParam2(){
             return SlideBarParam2.getValue();
    }
    
    private String getComboboxValue(){
             return ListGradient.getValue();
    }
    
    
    
    
    
    
    //----- Color management 
    public Color getColor1(){
            return convertJavafxColorToAwtColor( ColorPicker1.getValue());
    }
    public Color getColor2(){
            return convertJavafxColorToAwtColor( ColorPicker2.getValue());
       
    }
    
    public static java.awt.Color convertJavafxColorToAwtColor(javafx.scene.paint.Color javafxColor) {
        java.awt.Color awtColor = new java.awt.Color(
            (float) javafxColor.getRed(),
            (float) javafxColor.getGreen(),
            (float) javafxColor.getBlue(),
            (float) javafxColor.getOpacity()
        );
        return awtColor;
    }
    
    private javafx.scene.paint.Color convertAwtColorToJavafxColor(java.awt.Color awtColor) {
        return javafx.scene.paint.Color.rgb(awtColor.getRed(), awtColor.getGreen(), awtColor.getBlue(), awtColor.getAlpha() / 255.0);
    }
//-----------------------------------------------------------------------------------------------------------------------------    
    
}


