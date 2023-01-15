package com.example;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.autocomplete.TrieDictionary;
import com.example.document.FleshScore;
import com.example.generate.TextGenerator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable {

    @FXML
    private AnchorPane root;
    
    @FXML
    private ListView<String> palette;

    @FXML
    private Label featureDataLabel;

    @FXML
    private TextArea editorTextArea;
    
    private ListView<String> autocompleteListView;
    
    private boolean paletteVisibilityToggle;

    String[] options = {"Generate text",
                        "Toggle autocomplete",
                        "Toggle flesh score",
                        "Toggle spelling correction"};
    
    private boolean autocomplete;
    private TrieDictionary trieDictionary;
                        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        palette.getItems().addAll(options);
        palette.getItems().filtered(null);
        featureDataLabel.setVisible(false);
        autocompleteListView = new ListView<>();
        autocompleteListView.setLayoutX(330);
        autocompleteListView.setLayoutY(280);
        autocompleteListView.setVisible(false);
        AnchorPane.setRightAnchor(autocompleteListView, 25.0);
        root.getChildren().add(autocompleteListView);
        trieDictionary = new TrieDictionary();
        trieDictionary.initialize();
        autocompleteListView.setOnKeyPressed((e) -> {
            if(e.getCode() == KeyCode.ENTER) {
                autocompleteListView.setVisible(false);
                String selectedItem = autocompleteListView.getSelectionModel().getSelectedItem();
                String newText = editorTextArea.getText().replaceFirst("[a-zA-Z]+$", selectedItem);
                editorTextArea.setText(newText);
                editorTextArea.end();
            }
        });
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
        TextGenerator textGenerator = new TextGenerator(editorTextArea.getText());
        textGenerator.trainModel();
        featureDataLabel.setText(textGenerator.generate(75));
        featureDataLabel.setVisible(true);
    }

    // TODO
    private void toggleAutocomplete() {
        autocomplete = !autocomplete;
        autocompleteListView.setVisible(autocomplete);
        editorTextArea.requestFocus();
    }

    @FXML
    public void autocomplete() {
        if(autocomplete) {
            String[] allUserInputText = editorTextArea.getText().split(" ");
            String userInputText = allUserInputText[allUserInputText.length - 1];
            List<String> possibleWords = trieDictionary.getPossibleWords(userInputText, 10);
            autocompleteListView.getItems().clear();
            autocompleteListView.getItems().addAll(possibleWords);
            autocompleteListView.setVisible(true);
        }
    }

    @FXML
    public void focusAutocompleteListView(KeyEvent e) {
        if(e.getCode() == KeyCode.DOWN) {
            autocompleteListView.requestFocus();
        }
    }
    
    private void toggleFleshScore() {
        FleshScore fleshScore = new FleshScore(editorTextArea.getText());
        featureDataLabel.setText(String.format("%.2f", fleshScore.getFleschScore()));
        featureDataLabel.setVisible(true);
    }
    
    // TODO
    private void toggleSpellingCorrection() {
    }
}
