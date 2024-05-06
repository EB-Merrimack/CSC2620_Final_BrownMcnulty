package com.mycompany.mavenproject1;

import javafx.animation.FadeTransition;
import javafx.beans.binding.Bindings;
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
        // Create BorderPane layout
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: royalblue; -fx-padding: 20px;");

        // Load images
        List<Image> images = new ArrayList<>();
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Entrance.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor1.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor2.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor3.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor4.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor5.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor6.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs Part 2-20240506T190054Z-001/CSC2620 Campus Photos Downstairs Part 2/510Lowerfloor7.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor8.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs Part 2-20240506T190054Z-001/CSC2620 Campus Photos Downstairs Part 2/510Lowerfloor10.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor11.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor12.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor13.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor14.png"));





        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor2.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor3.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor4.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor5.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor6.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor7.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor8.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor10.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor11.png"));
        images.add(new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor12.png"));

        // Create ImageView
        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setImage(images.get(0)); // Set initial image

        // Bind fit width and height of ImageView to size of BorderPane's center region
        imageView.fitWidthProperty().bind(root.widthProperty().divide(1.5));
        imageView.fitHeightProperty().bind(root.heightProperty().divide(1.5));

        // Create navigation buttons
        VBox leftNavButtons = createLeftNavigationButtons(images, imageView);
        VBox rightNavButtons = createRightNavigationButtons(images, imageView);
        leftNavButtons.setAlignment(Pos.CENTER);
        rightNavButtons.setAlignment(Pos.CENTER);
        leftNavButtons.setSpacing(20);
        rightNavButtons.setSpacing(20);
        BorderPane.setAlignment(leftNavButtons, Pos.CENTER_LEFT);
        BorderPane.setAlignment(rightNavButtons, Pos.CENTER_RIGHT);

        // Add ImageView and navigation buttons to BorderPane
        root.setCenter(imageView);
        root.setLeft(leftNavButtons);
        root.setRight(rightNavButtons);

        // Create a Scene
        Scene scene = new Scene(root, 800, 500); // Initial scene size

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle(buildingName + " Details");
        primaryStage.show();
    }

    private static VBox createLeftNavigationButtons(List<Image> images, ImageView imageView) {
        VBox navButtons = new VBox();
        navButtons.setStyle("-fx-background-color: transparent;");

        // Create left button
        Button leftButton = new Button("←");
        leftButton.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");
        leftButton.setOnAction(event -> {
            int currentIndex = images.indexOf(imageView.getImage());
            if (currentIndex > 0) {
                imageView.setImage(images.get(currentIndex - 1));
                applyFadeTransition(imageView);
            }
        });

        navButtons.getChildren().add(leftButton);
        return navButtons;
    }

    private static VBox createRightNavigationButtons(List<Image> images, ImageView imageView) {
        VBox navButtons = new VBox();
        navButtons.setStyle("-fx-background-color: transparent;");

        // Create right button
        Button rightButton = new Button("→");
        rightButton.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");
        rightButton.setOnAction(event -> {
            int currentIndex = images.indexOf(imageView.getImage());
            if (currentIndex < images.size() - 1) {
                imageView.setImage(images.get(currentIndex + 1));
                applyFadeTransition(imageView);
            }
        });

        navButtons.getChildren().add(rightButton);
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
