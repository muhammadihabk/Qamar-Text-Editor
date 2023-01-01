package com.example;

import javafx.application.Application;
import javafx.scene.Group;
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
        Group root = new Group();
        Scene scene1 = new Scene(root, 500, 500);
        scene1.setFill(Color.web("0x191919"));

        Image appIcon = new Image(getClass().getResource("assets/appIcon.png").toURI().toString());
        Text someText = new Text("HELLO HELLO!");
        someText.setX(50);
        someText.setY(50);

        root.getChildren().add(someText);
        primaryStage.getIcons().add(appIcon);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Qamar");
        primaryStage.show();
    }

}