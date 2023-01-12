package com.example;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller implements Initializable {

    @FXML
    private ListView<String> palette;

    private boolean paletteVisibilityToggle = false;

    String[] options = {"Generate text",
                        "Toggle autocomplete",
                        "Toggle flesh score",
                        "Toggle spelling correction"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        palette.getItems().addAll(options);
        palette.getItems().filtered(null);
    }

    @FXML
    private void chooseOption(KeyEvent e) {
        if(e.getCode() == KeyCode.ENTER) {
            String selectedItem = palette.getSelectionModel().getSelectedItem();
            for(String option : options) {
                if(option.equals(selectedItem)) {
                    togglePaletteVisibility();
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
    
}
