package com.mycompany.mavenproject1;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class fivetendetailsgui {

    public static void showBuildingDetails(Stage primaryStage, String buildingName) {
        VBox root = new VBox(10);
        root.setPrefSize(400, 300);
        root.setStyle("-fx-background-color: lightgray; -fx-padding: 20px;");
        
        // Add building details
        Label titleLabel = new Label("Details for " + buildingName);
        Label descriptionLabel = new Label("This is a detailed description of " + buildingName + ".");
        
        root.getChildren().addAll(titleLabel, descriptionLabel);
        
        // Create a Scene
        Scene scene = new Scene(root);
        
        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle(buildingName + " Details");
        primaryStage.show();
    }
}
