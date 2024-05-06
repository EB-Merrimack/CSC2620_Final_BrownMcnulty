package com.mycompany.mavenproject1;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class fivetendetailsgui {

    private static final int TRANSITION_DURATION = 500; // Duration for transition in milliseconds

    public static void showBuildingDetails(Stage primaryStage, String buildingName) {
        // Create VBox layout
        VBox root = new VBox(10);
        root.setPrefSize(600, 400); // Increased size
        root.setStyle("-fx-background-color: lightgray; -fx-padding: 20px;");

        // Load images
        List<Image> images = new ArrayList<>();
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor1.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor2.png"));

        // Create ImageView
        ImageView imageView = new ImageView();
        imageView.setFitWidth(500); // Increased width
        imageView.setFitHeight(300); // Increased height
        imageView.setPreserveRatio(true);
        imageView.setImage(images.get(0)); // Set initial image

        // Create navigation buttons
        HBox navButtons = createNavigationButtons(images, imageView);

        // Add ImageView and navigation buttons to VBox
        root.getChildren().addAll(imageView, navButtons);

        // Create a Scene
        Scene scene = new Scene(root);

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle(buildingName + " Details");
        primaryStage.show();
    }

    private static HBox createNavigationButtons(List<Image> images, ImageView imageView) {
        HBox navButtons = new HBox(10);
        navButtons.setStyle("-fx-padding: 10px;");

        // Create left button
        Button leftButton = new Button("←");
        leftButton.setOnAction(event -> {
            int currentIndex = images.indexOf(imageView.getImage());
            if (currentIndex > 0) {
                imageView.setImage(images.get(currentIndex - 1));
                applyFadeTransition(imageView);
            }
        });

        // Create right button
        Button rightButton = new Button("→");
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
