package batcher_foyer;

import ParamPanes.ParamPane;
import ParamPanes.ParamPaneColor;
import ParamPanes.ParamPaneDecoration;
import ParamPanes.ParamPaneGreenConso;
import ParamPanes.ParamPaneIllustration;
import ParamPanes.ParamPaneConso;
import ParamPanes.ParamPaneItem;
import ParamPanes.ParamPaneShape;
import ParamPanes.ParamPaneText;
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
         private final List<ParamPane> illustrationParamPanes;
         private final List<ParamPane> shapeParamPanes;
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
                  } else if (paramPane instanceof ParamPaneIllustration) {
                           illustrationsAccordion.getPanes().add(titledPane);
                           illustrationParamPanes.add(paramPane);
                  } else if (paramPane instanceof ParamPaneShape) {
                           shapesAccordion.getPanes().add(titledPane);
                           shapeParamPanes.add(paramPane);
                  } else if (paramPane instanceof ParamPaneDecoration) {
                           decorationsAccordion.getPanes().add(titledPane);
                           decorationParamPanes.add(paramPane);
                  } else if (paramPane instanceof ParamPaneConso) {
                           consosAccordion.getPanes().add(titledPane);
                           consoParamPanes.add(paramPane);
                  } else if (paramPane instanceof ParamPaneItem) {
                           itemsAccordion.getPanes().add(titledPane);
                           itemParamPanes.add(paramPane);
                  } else if (paramPane instanceof ParamPaneGreenConso) {
                           greenConsosAccordion.getPanes().add(titledPane);
                           greenConsoParamPanes.add(paramPane);
                  } else if (paramPane instanceof ParamPaneText) {
                           textAccordion.getPanes().add(titledPane);
                           textParamPanes.add(paramPane);
                  }
         }

         public void deleteParamPane(ParamPane paramPane) {
                  TitledPane titledPane = paramPane.getTitledPane();
                  if (paramPane instanceof ParamPaneColor) {
                           colorsAccordion.getPanes().remove(titledPane);
                           colorParamPanes.remove(paramPane);
                  } else if (paramPane instanceof ParamPaneIllustration) {
                           illustrationsAccordion.getPanes().remove(titledPane);
                           illustrationParamPanes.remove(paramPane);
                  } else if (paramPane instanceof ParamPaneShape) {
                           shapesAccordion.getPanes().remove(titledPane);
                           shapeParamPanes.remove(paramPane);
                  } else if (paramPane instanceof ParamPaneDecoration) {
                           decorationsAccordion.getPanes().remove(titledPane);
                           decorationParamPanes.remove(paramPane);
                  } else if (paramPane instanceof ParamPaneConso) {
                           consosAccordion.getPanes().remove(titledPane);
                           consoParamPanes.remove(paramPane);
                  } else if (paramPane instanceof ParamPaneConso) {
                           itemsAccordion.getPanes().remove(titledPane);
                           itemParamPanes.remove(paramPane);
                  } else if (paramPane instanceof ParamPaneGreenConso) {
                           greenConsosAccordion.getPanes().remove(titledPane);
                           greenConsoParamPanes.remove(paramPane);
                  } else if (paramPane instanceof ParamPaneText) {
                           textAccordion.getPanes().remove(titledPane);
                           textParamPanes.remove(paramPane);
                  }
         }
}
