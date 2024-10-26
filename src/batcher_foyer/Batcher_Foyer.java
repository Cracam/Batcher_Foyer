
package batcher_foyer;

import Exceptions.ACardModelIsLackingException;
import Exceptions.ResourcesFileErrorException;
import ImageBuilder.CardBuilder;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author LECOURT Camille
 */
public class Batcher_Foyer extends Application{
            private CardBuilder CardRecto;
            private CardBuilder CardVerso;
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
                try{
                URL[] urlList= new URL[1];
                URL inter_principalle = getClass().getClassLoader().getResource("InterfaceBatcher.fxml");
                urlList[0]=inter_principalle;
                loadCardModel();
                if (CheckArrayHaveNull(urlList)){
                    throw new ResourcesFileErrorException("One or more files are missing in the ressources files");
                }


                Parent root =FXMLLoader.load(inter_principalle);
                primarystage.setTitle("hello");
                primarystage.setScene(new Scene(root));
                primarystage.show();

                }catch(ResourcesFileErrorException e){

                }
        }

    @Override
    public String toString() {
        return "Batcher_Foyer{" + "CardRecto=" + CardRecto + ", CardVerso=" + CardVerso + ", name=" + name + ", size_x=" + size_x + ", size_y=" + size_y + '}';
    }
    
    
    
    
    
    
    
    
    
     private void loadCardModel(){
                try{
                          File file = new File(getResourcesPath("ParamCartesFoyer.xml"));
                          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                          DocumentBuilder db = dbf.newDocumentBuilder();
                          Document doc = db.parse(file);
                          doc.getDocumentElement().normalize();
                          System.out.println("Root element " + doc.getDocumentElement().getNodeName());
                          NodeList cardModels = doc.getElementsByTagName("Card_model");
                          
                          this.name=doc.getDocumentElement().getAttribute("name");
                         this.size_x = Float.parseFloat(doc.getDocumentElement().getAttribute("size_x"));
                         this.size_y=Float.parseFloat(doc.getDocumentElement().getAttribute("size_y"));
                         
                                      
                                      
                             this.CardRecto=null;
                             this.CardVerso=null;
                             for(int i=0;i<cardModels.getLength();i++){
                                      
                                       Node cardModel = cardModels.item(i);
                                       System.out.println(cardModel.getNodeName());
                                       
                                       if("Verso".equals(cardModel.getNodeName())){
                                                this.CardVerso = new CardBuilder("Verso", this.size_x,this.size_y);
                                       }
                                       if("Recto".equals(cardModel.getNodeName())){
                                                this.CardRecto = new CardBuilder("Recto", this.size_x,this.size_y);
                                       }
         
                            }
                            if (  this.CardRecto==null | this.CardVerso==null){
                            throw new ACardModelIsLackingException("Il n'y a pas les deux modèles de carte comme attendu");
                            }
                          
                          
                          
                           System.out.println(toString());
                          // CardRecto et CardVerso à remplir
                             
                }catch(  IOException | ParserConfigurationException | SAXException e){
                           System.out.println(e.getMessage());
                } catch (ACardModelIsLackingException ex) {
                    Logger.getLogger(Batcher_Foyer.class.getName()).log(Level.SEVERE, null, ex);
                }
         
     }
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This function retunr true if one or more null element is detected in the @array 
     * @param Array
     * @return 
     */
    private static boolean CheckArrayHaveNull(Object[] Array){
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
        return currentDir.getAbsolutePath()+"/resources/"+fileName;
    }
    
    
    
    
    
}
