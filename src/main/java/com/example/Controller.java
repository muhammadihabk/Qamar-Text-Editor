package com.example;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.generate.TextGenerator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller implements Initializable {

    @FXML
    private ListView<String> palette;

    @FXML
    private Label featureDataLabel;

    @FXML
    private TextArea editorTextArea;

    private boolean paletteVisibilityToggle = false;

    String[] options = {"Generate text",
                        "Toggle autocomplete",
                        "Toggle flesh score",
                        "Toggle spelling correction"};
    
    private TextGenerator textGenerator;
                        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        palette.getItems().addAll(options);
        palette.getItems().filtered(null);
        featureDataLabel.setVisible(false);
    }


    @FXML
    private void chooseOption(KeyEvent e) throws IOException {
        if(e.getCode() == KeyCode.ENTER) {
            String selectedItem = palette.getSelectionModel().getSelectedItem();
            for(String option : options) {
                if(selectedItem.equals(option)) {
                    togglePaletteVisibility();
                    if(option.equals("Generate text")) {
                        generateText();
                    } else if(option.equals("Toggle autocomplete")) {
                        toggleAutocomplete();
                    } else if(option.equals("Toggle flesh score")) {
                        toggleFleshScore();
                    } else {
                        toggleSpellingCorrection();
                    }
                    return;
                }
            }
        }
    }

    @FXML
    public void togglePaletteVisibility() {
        paletteVisibilityToggle = !paletteVisibilityToggle;
        palette.setVisible(paletteVisibilityToggle);
        if(paletteVisibilityToggle) {
            palette.requestFocus();
        }
            
    }
    
    private void generateText() {
        textGenerator = new TextGenerator(editorTextArea.getText());
        textGenerator.trainModel();
        featureDataLabel.setText(textGenerator.generate(75));
        featureDataLabel.setVisible(true);
    }

    // TODO
    private void toggleAutocomplete() {
    }
    
    // TODO
    private void toggleFleshScore() {
    }
    
    // TODO
    private void toggleSpellingCorrection() {
    }
}
