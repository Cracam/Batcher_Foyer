/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParamPanes;

/**
 *
 * @author LECOURT Camille
 */
import static batcher_foyer.Batcher_Foyer.getResourcesPath;
import com.sun.javafx.scene.control.skin.Utils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;

public abstract class ParamPane {
    private static Map<Class<? extends ParamPane>, Map<String, String>> variables = new HashMap<>();

    static {
        // load the variables from the XML file
        try {
            File file = new File(getResourcesPath( "ParamPanes.xml"));
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("paramPane");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String className = element.getAttribute("class");
                Class<? extends ParamPane> clazz = (Class<? extends ParamPane>) Class.forName(className);
                Map<String, String> variableMap = new HashMap<>();
                NodeList variableList = element.getChildNodes();
                for (int j = 0; j < variableList.getLength(); j++) {
                    if (variableList.item(j) instanceof Element) {
                        Element variableElement = (Element) variableList.item(j);
                        String variableName = variableElement.getTagName();
                        String variableValue = variableElement.getTextContent();
                        variableMap.put(variableName, variableValue);
                    }
                }
                variables.put(clazz, variableMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final TitledPane titledPane;
    private final String name;
    private boolean changed;
    protected ImageView preview;
    protected Map<String, String> variableMap;

    public ParamPane(String name) {
        this.name = name;
        this.changed = false;
        this.titledPane = new TitledPane(name, new Pane());
        this.variableMap = variables.getOrDefault(this.getClass(), new HashMap<>());
    }

    public TitledPane getTitledPane() {
        return titledPane;
    }

    public String getName() {
        return name;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void resetChanged() {
        changed = false;
    }

    public void applyChanges(){
        //TO DO
    }

    public abstract void setPreview(Image preview);

    public String getVariable(String name) {
        return variableMap.get(name);
    }

    static Image convertToMonocolor(Image image) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        PixelReader reader = image.getPixelReader();
        WritableImage writableImage = new WritableImage(width, height);
        PixelWriter writer = writableImage.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int argb = reader.getArgb(x, y);
                int alpha = (argb >> 24) & 0xff;
                int green = (alpha << 24) | 0x00ff00;
                writer.setArgb(x, y, green);
            }
        }
        return writableImage;
    }
}
