
package batcher_foyer;

import Exceptions.ResourcesFileErrorException;
import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author LECOURT Camille
 */
public class Batcher_Foyer extends Application{
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
    
    /**
     * This function retunr true if one or more null element is detected in the @array 
     * @param Array
     * @return 
     */
    private boolean CheckArrayHaveNull(Object[] Array){
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
    
    
    
    private void loadCardModel(){
          File file = new File(getClass().getClassLoader().getResource("InterfaceBatcher.fxml"));
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element " + doc.getDocumentElement().getNodeName());
            NodeList nodeListOfActiveComponements = doc.getElementsByTagName("ActiveComponement");
            
    }
    
    
    
    
    public static String getabsolutePath() {
        // Obtenir le répertoire courant du projet
        File currentDir = new File("");

        // Obtenir le chemin d'accès absolu du répertoire courant
        return currentDir.getAbsolutePath();
    }
    
    
    
    
    
}
