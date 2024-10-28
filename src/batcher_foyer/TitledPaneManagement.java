import ParamPanes.ParamPane;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import java.util.ArrayList;
import java.util.List;

public class TitledPaneManagement {

         private final Accordion colorsAccordion;
         private final Accordion illustrationsAccordion;
         private final Accordion shapesAccordion;
         private final Accordion decorationsAccordion;
         private final Accordion consosAccordion;
         private final Accordion itemsAccordion;
         private final Accordion greenConsosAccordion;
         private final Accordion textAccordion;

    private final List<ParamPane> colorParamPanes;
    private  final List<ParamPane> illustrationParamPanes;
    private final  List<ParamPane> shapeParamPanes;
    private final List<ParamPane> decorationParamPanes;
    private final List<ParamPane> consoParamPanes;
    private final List<ParamPane> itemParamPanes;
    private final List<ParamPane> greenConsoParamPanes;
    private final List<ParamPane> textParamPanes;

    public TitledPaneManagement(Accordion colorsAccordion, Accordion illustrationsAccordion, Accordion shapesAccordion,
                                Accordion decorationsAccordion, Accordion consosAccordion, Accordion itemsAccordion,
                                Accordion greenConsosAccordion, Accordion textAccordion) {
        this.colorsAccordion = colorsAccordion;
        this.illustrationsAccordion = illustrationsAccordion;
        this.shapesAccordion = shapesAccordion;
        this.decorationsAccordion = decorationsAccordion;
        this.consosAccordion = consosAccordion;
        this.itemsAccordion = itemsAccordion;
        this.greenConsosAccordion = greenConsosAccordion;
        this.textAccordion = textAccordion;

        this.colorParamPanes = new ArrayList<>();
        this.illustrationParamPanes = new ArrayList<>();
        this.shapeParamPanes = new ArrayList<>();
        this.decorationParamPanes = new ArrayList<>();
        this.consoParamPanes = new ArrayList<>();
        this.itemParamPanes = new ArrayList<>();
        this.greenConsoParamPanes = new ArrayList<>();
        this.textParamPanes = new ArrayList<>();
    }

    public void addParamPane(ParamPane paramPane) {
        TitledPane titledPane = paramPane.getTitledPane();
        if (paramPane instanceof ParamPaneColor) {
            colorsAccordion.getPanes().add(titledPane);
            colorParamPanes.add(paramPane);
        } else if (paramPane instanceof IllustrationParamPane) {
            illustrationsAccordion.getPanes().add(titledPane);
            illustrationParamPanes.add(paramPane);
        } else if (paramPane instanceof ShapeParamPane) {
            shapesAccordion.getPanes().add(titledPane);
            shapeParamPanes.add(paramPane);
        } else if (paramPane instanceof DecorationParamPane) {
            decorationsAccordion.getPanes().add(titledPane);
            decorationParamPanes.add(paramPane);
        } else if (paramPane instanceof ConsoParamPane) {
            consosAccordion.getPanes().add(titledPane);
            consoParamPanes.add(paramPane);
        } else if (paramPane instanceof ItemParamPane) {
            itemsAccordion.getPanes().add(titledPane);
            itemParamPanes.add(paramPane);
        } else if (paramPane instanceof GreenConsoParamPane) {
            greenConsosAccordion.getPanes().add(titledPane);
            greenConsoParamPanes.add(paramPane);
        } else if (paramPane instanceof TextParamPane) {
            textAccordion.getPanes().add(titledPane);
            textParamPanes.add(paramPane);
        }
    }

    public void deleteParamPane(ParamPane paramPane) {
        TitledPane titledPane = paramPane.getTitledPane();
        if (paramPane instanceof ParamPaneColor) {
            colorsAccordion.getPanes().remove(titledPane);
            colorParamPanes.remove(paramPane);
        } else if (paramPane instanceof IllustrationParamPane) {
            illustrationsAccordion.getPanes().remove(titledPane);
            illustrationParamPanes.remove(paramPane);
        } else if (paramPane instanceof ShapeParamPane) {
            shapesAccordion.getPanes().remove(titledPane);
            shapeParamPanes.remove(paramPane);
        } else if (paramPane instanceof DecorationParamPane) {
            decorationsAccordion.getPanes().remove(titledPane);
            decorationParamPanes.remove(paramPane);
        } else if (paramPane instanceof ConsoParamPane) {
            consosAccordion.getPanes().remove(titledPane);
            consoParamPanes.remove(paramPane);
        } else if (paramPane instanceof ItemParamPane) {
            itemsAccordion.getPanes().remove(titledPane);
            itemParamPanes.remove(paramPane);
        } else if (paramPane instanceof GreenConsoParamPane) {
            greenConsosAccordion.getPanes().remove(titledPane);
            greenConsoParamPanes.remove(paramPane);
        } else if (paramPane instanceof TextParamPane) {
            textAccordion.getPanes().remove(titledPane);
            textParamPanes.remove(paramPane);
        }
    }
}
