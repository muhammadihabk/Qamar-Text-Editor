package com.example;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/home.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("css/stylesheet.css").toExternalForm());

        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            final KeyCombination keyComb = new KeyCodeCombination(KeyCode.P,
                                                KeyCombination.CONTROL_DOWN,
                                                KeyCombination.SHIFT_DOWN);
            public void handle(KeyEvent ke) {
                if (keyComb.match(ke)) {
                    controller.togglePaletteVisibility();
                    ke.consume();
                }
            }
        });

        Image appIcon = new Image(getClass().getResource("images/appIcon.png").toURI().toString());
        
        primaryStage.getIcons().add(appIcon);
        primaryStage.setScene(scene);
        primaryStage.setTitle("QamarKeez");
        primaryStage.setWidth(Screen.getPrimary().getBounds().getWidth());
        primaryStage.setHeight(Screen.getPrimary().getBounds().getHeight());
        primaryStage.show();
    }

}