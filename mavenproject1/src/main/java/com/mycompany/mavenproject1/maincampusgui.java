package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class maincampusgui {
    private static final int TRANSITION_DURATION = 250; // Duration for transition in milliseconds

    public static void showBuildingDetails(Stage primaryStage, String buildingName) {
        // Create BorderPane layout
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: royalblue; -fx-padding: 20px;");

         // Load images
        List<ImageWithCaptions> images = new ArrayList<>();
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/MapOfCampus.png", "Map of main campus"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Entrance.png", "Campus Entrance"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Arcidi.png", "Arcidi Center: Tour Check In Point"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/BowlingAlley.png", "Bowling Alley in the Student Union"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Mcquade.png", "McQuade Library"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Sak.png", "Sakowich Campus Center"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Sparky's.png", "Sparky's: Main Dining Hall On Campus"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Den.png", "Warrior's Den: Another Dining Option Within The Sakowich Center"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Gym.png", "Gym"));

        ImageView imageView = new ImageView();

        // Initial image and caption
        ImageWithCaptions initialImage = images.get(0);
        imageView.setImage(new Image(initialImage.getImageUrl()));
        Label captionLabel = new Label(initialImage.getCaption());

        // Bind fit width and height of ImageView to size of BorderPane's center region
        imageView.fitWidthProperty().bind(root.widthProperty().divide(1.5));
        imageView.fitHeightProperty().bind(root.heightProperty().divide(1.5));

        // Create navigation buttons
        VBox leftNavButtons = createLeftNavigationButtons(images, imageView, captionLabel);
        VBox rightNavButtons = createRightNavigationButtons(images, imageView, captionLabel);
        VBox gobackButton = createGobackButton(primaryStage);

       
        // Create navigation buttons
        gobackButton.setAlignment(Pos.CENTER);
        leftNavButtons.setAlignment(Pos.CENTER);
        rightNavButtons.setAlignment(Pos.CENTER);
        leftNavButtons.setSpacing(20);
        rightNavButtons.setSpacing(20);
        BorderPane.setAlignment(leftNavButtons, Pos.CENTER_LEFT);
        BorderPane.setAlignment(rightNavButtons, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(gobackButton, Pos.BASELINE_CENTER);

        // Add ImageView and navigation buttons to BorderPane
        root.setCenter(imageView);
        root.setLeft(leftNavButtons);
        root.setRight(rightNavButtons);
        root.setBottom(gobackButton);
        root.setBottom(captionLabel);

        // Create a Scene
        Scene scene = new Scene(root, 800, 500); // Initial scene size

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Slideshow with Captions");
        primaryStage.show();
    }

    private static VBox createLeftNavigationButtons(List<ImageWithCaptions> imagesWithCaptions, ImageView imageView, Label captionLabel) {
        VBox navButtons = new VBox();
        navButtons.setStyle("-fx-background-color: transparent;");

        // Create left button
        Button leftButton = new Button("←");
        leftButton.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");
        leftButton.setOnAction(event -> {
            int currentIndex = getCurrentIndex(imagesWithCaptions, imageView.getImage());
            if (currentIndex > 0) {
                ImageWithCaptions prevImage = imagesWithCaptions.get(currentIndex - 1);
                imageView.setImage(new Image(prevImage.getImageUrl()));
                captionLabel.setText(prevImage.getCaption());
            }
        });

        navButtons.getChildren().add(leftButton);
        return navButtons;
    }

    private static VBox createRightNavigationButtons(List<ImageWithCaptions> imagesWithCaptions, ImageView imageView, Label captionLabel) {
        VBox navButtons = new VBox();
        navButtons.setStyle("-fx-background-color: transparent;");

        // Create right button
        Button rightButton = new Button("→");
        rightButton.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");
        rightButton.setOnAction(event -> {
            int currentIndex = getCurrentIndex(imagesWithCaptions, imageView.getImage());
            if (currentIndex < imagesWithCaptions.size() - 1) {
                ImageWithCaptions nextImage = imagesWithCaptions.get(currentIndex + 1);
                imageView.setImage(new Image(nextImage.getImageUrl()));
                captionLabel.setText(nextImage.getCaption());
            }
        });

        navButtons.getChildren().add(rightButton);
        return navButtons;
    }

    private static VBox createGobackButton(Stage primaryStage) {
        VBox navButtons = new VBox();
        navButtons.setStyle("-fx-background-color: transparent;");

        // Create goback button
        Button goback = new Button("Return to Building Options");
        goback.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");
        goback.setOnAction(event -> {
            BuildingOptionsGUI buildingOptionsGUI = new BuildingOptionsGUI();
            buildingOptionsGUI.start(primaryStage);
        });

        navButtons.getChildren().add(goback);
        return navButtons;
    }

    // Helper method to get current index of the displayed image
    private static int getCurrentIndex(List<ImageWithCaptions> imagesWithCaptions, Image currentImage) {
        for (int i = 0; i < imagesWithCaptions.size(); i++) {
            if (imagesWithCaptions.get(i).getImageUrl().equals(currentImage.getUrl())) {
                return i;
            }
        }
        return -1;
    }
}