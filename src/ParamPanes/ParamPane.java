/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParamPanes;

/**
 *
 * @author LECOURT Camille
 */
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;

public abstract class ParamPane {

         private final TitledPane titledPane;
         private final String name;
         private boolean changed;

         public ParamPane(String name) {
                  this.name = name;
                  this.changed = false;
                  this.titledPane = new TitledPane(name, new Pane());
                  this.titledPane.expandedProperty().addListener(new ChangeListener<Boolean>() {
                           @Override
                           public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                                    changed = true;
                           }
                  });
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

         public void resetChanged() {
                  changed = false;
         }

         public void applyChanges(){
                          }
         
         
}
