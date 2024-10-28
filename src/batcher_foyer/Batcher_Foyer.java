package batcher_foyer;

import Exceptions.ACardModelIsLackingException;
import Exceptions.ResourcesFileErrorException;
import ImageBuilder.CardBuilder;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author LECOURT Camille
 */
public class Batcher_Foyer extends Application {
         private static String moduleAddress;
         
         private CardBuilder CardRecto;
         @FXML
         private ImageView imageViewRecto;
        
         private CardBuilder CardVerso;
         @FXML
         private ImageView imageViewVerso;
         
         private String name;
         private float size_x;
         private float size_y;

         /**
          * @param args the command line arguments
          */
         public static void main(String[] args) {
                  launch(args);
         }

         @Override
         public void start(Stage primarystage) throws Exception {
                  try {
                           URL[] urlList = new URL[1];
                           URL inter_principalle = getClass().getClassLoader().getResource("InterfaceBatcher.fxml");
                           urlList[0] = inter_principalle;
//                           System.out.println(inter_principalle);
                           loadCardModel();
                           if (CheckArrayHaveNull(urlList)) {
                                    throw new ResourcesFileErrorException("One or more files are missing in the ressources files");
                           }

                           Parent root = FXMLLoader.load(inter_principalle);
                           primarystage.setTitle("hello");
                           primarystage.setScene(new Scene(root));
                           primarystage.show();
                           

                  } catch (ResourcesFileErrorException e) {

                  }
         }

         @Override
         public String toString() {
                  return "Batcher_Foyer{\nCardRecto=" + CardRecto.toString() + "\n\n CardVerso=" + CardVerso.toString() + "\n\n name=" + name + ", size_x=" + size_x + ", size_y=" + size_y + '}';
         }
         
         
         
         
         /**
          * This function will load the data from the XML file and will pass it to the 2 new cardBuilder object
          */
         private void loadCardModel() {
                  try {
                           File file = new File(getResourcesPath("ParamCartesFoyer.xml"));
                           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                           DocumentBuilder db = dbf.newDocumentBuilder();
                           Document doc = db.parse(file);
                           doc.getDocumentElement().normalize();

                           this.name = doc.getDocumentElement().getAttribute("name");
                           this.size_x = Float.parseFloat(doc.getDocumentElement().getAttribute("size_x"));
                           this.size_y = Float.parseFloat(doc.getDocumentElement().getAttribute("size_y"));

                           this.CardRecto = null;
                           this.CardVerso = null;

                           NodeList versoElements = doc.getElementsByTagName("Verso").item(0).getChildNodes();
                           NodeList rectoElements = doc.getElementsByTagName("Recto").item(0).getChildNodes();

                           List<Node> versoElementList = new ArrayList<>();
                           List<Node> rectoElementList = new ArrayList<>();

                           for (int i = 0; i < versoElements.getLength(); i++) {
                                    Node node = versoElements.item(i);
                                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                                             versoElementList.add(node);
                                    }
                           }

                           for (int i = 0; i < rectoElements.getLength(); i++) {
                                    Node node = rectoElements.item(i);
                                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                                             rectoElementList.add(node);
                                    }
                           }

                           if (rectoElementList.size() <= 0 | versoElementList.size() <= 0) {
                                    throw new ACardModelIsLackingException("Il n'y a pas les deux modèles de carte comme attendu");
                           }

                           this.CardRecto = new CardBuilder("Recto", this.size_x, this.size_y);
                           this.CardRecto.setLayers(rectoElementList);
                           this.CardRecto.setImageView(this.imageViewRecto);

                           this.CardVerso = new CardBuilder("Verso", this.size_x, this.size_y);
                           this.CardVerso.setLayers(versoElementList);
                           this.CardVerso.setImageView(this.imageViewVerso);

                           System.out.println(toString());
                           // CardRecto et CardVerso à remplir

                  } catch (IOException | ParserConfigurationException | SAXException e) {
                           System.out.println(e.getMessage());
                  } catch (ACardModelIsLackingException ex) {
                           Logger.getLogger(Batcher_Foyer.class.getName()).log(Level.SEVERE, null, ex);
                  }

         }

         /**
          * This function retunr true if one or more null element is detected in
          * the @array
          *
          * @param Array
          * @return
          */
         private static boolean CheckArrayHaveNull(Object[] Array) {
                  // Check if array contains null elements
                  boolean containsNull = false;
                  for (Object obj : Array) {
                           if (obj == null) {
                                    containsNull = true;
                                    break;
                           }
                  }
                  return containsNull;
         }

         /**
          *
          * @param fileName
          * @return Return the absoute address of the fileName
          */
         public static String getResourcesPath(String fileName) {
                  // Obtenir le répertoire courant du projet
                  File currentDir = new File("");

                  // Obtenir le chemin d'accès absolu du répertoire courant
                  return currentDir.getAbsolutePath() + "/resources/" + fileName;
         }

         public static String getModuleAddress() {
                  return moduleAddress;
         }
         
         public static String getModulePath(String fileName) {
                  return moduleAddress+"/"+fileName;
         }

         public static void setModuleAddress(String moduleAddress) {
                  Batcher_Foyer.moduleAddress = moduleAddress;
         }
         
         

}
