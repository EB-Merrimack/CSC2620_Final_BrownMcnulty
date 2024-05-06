package com.mycompany.mavenproject1;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        root.setPrefSize(400, 300);
        root.setStyle("-fx-background-color: lightgray; -fx-padding: 20px;");

        // Load images
        List<Image> images = new ArrayList<>();
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor1.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor2.png"));

        // Create ImageView
        ImageView imageView = new ImageView();
        imageView.setFitWidth(300);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);
        imageView.setImage(images.get(0)); // Set initial image

        // Handle arrow key presses to switch images
        int[] currentIndex = {0}; // Using an array to hold index for mutable reference
        root.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:
                    currentIndex[0] = Math.max(0, currentIndex[0] - 1);
                    break;
                case RIGHT:
                    currentIndex[0] = Math.min(images.size() - 1, currentIndex[0] + 1);
                    break;
                default:
                    break;
            }
            imageView.setImage(images.get(currentIndex[0]));
            applyFadeTransition(imageView);
        });

        // Add ImageView to VBox
        root.getChildren().add(imageView);

        // Create a Scene
        Scene scene = new Scene(root);

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle(buildingName + " Details");
        primaryStage.show();
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
