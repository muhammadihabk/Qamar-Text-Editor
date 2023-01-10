package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/landingPage.fxml"));
        Scene scene1 = new Scene(root);
        scene1.setFill(Color.web("0x191919"));

        Image appIcon = new Image(getClass().getResource("images/appIcon.png").toURI().toString());
        
        primaryStage.getIcons().add(appIcon);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Qamar");
        primaryStage.show();
    }

}