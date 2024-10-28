/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParamPanes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ParamPaneText extends ParamPane {
    private final Label sizeFactorLabel;
    private final TextField sizeFactorTextField;
    private final Label heightOffsetLabel;
    private final TextField heightOffsetTextField;

    public ParamPaneText(String name) {
        super(name);
        sizeFactorLabel = new Label("Facteur de taille du texte");
        sizeFactorTextField = new TextField();
        heightOffsetLabel = new Label("Décalage de hauteur du texte");
        heightOffsetTextField = new TextField();
        VBox vbox = new VBox(sizeFactorLabel, sizeFactorTextField, heightOffsetLabel, heightOffsetTextField);
        getTitledPane().setContent(vbox);

        sizeFactorTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setChanged(true);
            }
        });

        heightOffsetTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setChanged(true);
            }
        });
    }

    public String getSizeFactor() {
        return sizeFactorTextField.getText();
    }

    public void setSizeFactor(String sizeFactor) {
        sizeFactorTextField.setText(sizeFactor);
    }

    public String getHeightOffset() {
        return heightOffsetTextField.getText();
    }

    public void setHeightOffset(String heightOffset) {
        heightOffsetTextField.setText(heightOffset);
    }

}
