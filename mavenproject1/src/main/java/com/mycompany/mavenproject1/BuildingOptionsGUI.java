package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuildingOptionsGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create buttons for Main Campus and East Campus
        Button mainCampusButton = new Button("Main Campus");
        Button eastCampusButton = new Button("East Campus");

        // Set action for Main Campus button
        mainCampusButton.setOnAction(e -> {
            System.out.println("Main Campus option selected");
            // Implement your logic for Main Campus here
        });

        // Set action for East Campus button
        eastCampusButton.setOnAction(e -> {
            System.out.println("East Campus option selected");
            // Implement your logic for East Campus here
        });

        // Create a VBox to hold the buttons
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(mainCampusButton, eastCampusButton);

        // Create a Scene
        Scene scene = new Scene(vbox, 300, 200);

        // Set the scene and show the stage
        primaryStage.setTitle("Building Options");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
