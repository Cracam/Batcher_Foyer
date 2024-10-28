/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParamPanes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class ParamPaneGreenConso extends ParamPane {
    private final Label sizeFactorLabel;
    private final TextField sizeFactorTextField;
    private final Label heightOffsetLabel;
    private final TextField heightOffsetTextField;

    public ParamPaneGreenConso(String name) {
        super(name);
        sizeFactorLabel = new Label("Facteur de taille des feuilles");
        sizeFactorTextField = createFloatTextField();
        heightOffsetLabel = new Label("Décalage de hauteur des feuilles");
        heightOffsetTextField = createFloatTextField();
        VBox vbox = new VBox(sizeFactorLabel, sizeFactorTextField, heightOffsetLabel, heightOffsetTextField);
        getTitledPane().setContent(vbox);

        sizeFactorTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setChanged( true);
            }
        });

        heightOffsetTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setChanged( true);
            }
        });
    }

    private TextField createFloatTextField() {
        Pattern pattern = Pattern.compile("-?\\d*(\\.\\d*)?");
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (pattern.matcher(change.getControlNewText()).matches()) {
                return change;
            } else {
                return null;
            }
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        TextField textField = new TextField();
        textField.setTextFormatter(textFormatter);
        return textField;
    }

    public float getSizeFactor() {
        return Float.parseFloat(sizeFactorTextField.getText());
    }

    public void setSizeFactor(float sizeFactor) {
        sizeFactorTextField.setText(String.valueOf(sizeFactor));
    }

    public float getHeightOffset() {
        return Float.parseFloat(heightOffsetTextField.getText());
    }

    public void setHeightOffset(float heightOffset) {
        heightOffsetTextField.setText(String.valueOf(heightOffset));
    }

 
}
