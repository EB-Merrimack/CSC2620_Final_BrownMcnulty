package com.mycompany.mavenproject1;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class fivetendetailsgui {

    private static final int TRANSITION_DURATION = 500; // Duration for transition in milliseconds

    public static void showBuildingDetails(Stage primaryStage, String buildingName) {
        // Create StackPane layout
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: rgba(0, 0, 128, 0.5); -fx-padding: 20px;");

        // Load images
        List<Image> images = new ArrayList<>();
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor1.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor2.png"));

        // Create ImageView
        ImageView imageView = new ImageView();
        imageView.setFitWidth(600); // Increased width
        imageView.setFitHeight(400); // Increased height
        imageView.setPreserveRatio(true);
        imageView.setImage(images.get(0)); // Set initial image

        // Create navigation buttons
        HBox navButtons = createNavigationButtons(images, imageView);
        navButtons.setAlignment(Pos.CENTER);
        navButtons.setSpacing(20);

        // Add ImageView and navigation buttons to StackPane
        root.getChildren().addAll(imageView, navButtons);

        // Create a Scene
        Scene scene = new Scene(root, 600, 400);

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle(buildingName + " Details");
        primaryStage.show();
    }

    private static HBox createNavigationButtons(List<Image> images, ImageView imageView) {
        HBox navButtons = new HBox();
        navButtons.setStyle("-fx-background-color: transparent;");

        // Create left button
        Button leftButton = new Button("←");
        leftButton.setStyle("-fx-background-color: gold;");
        leftButton.setOnAction(event -> {
            int currentIndex = images.indexOf(imageView.getImage());
            if (currentIndex > 0) {
                imageView.setImage(images.get(currentIndex - 1));
                applyFadeTransition(imageView);
            }
        });

        // Create right button
        Button rightButton = new Button("→");
        rightButton.setStyle("-fx-background-color: gold;");
        rightButton.setOnAction(event -> {
            int currentIndex = images.indexOf(imageView.getImage());
            if (currentIndex < images.size() - 1) {
                imageView.setImage(images.get(currentIndex + 1));
                applyFadeTransition(imageView);
            }
        });

        navButtons.getChildren().addAll(leftButton, rightButton);
        return navButtons;
    }

    private static void applyFadeTransition(ImageView imageView) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(TRANSITION_DURATION), imageView);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);

        fadeTransition.setOnFinished(event -> {
            imageView.setOpacity(1.0); // Reset opacity after transition
        });

        fadeTransition.play();
    }
}
