package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ComputerScienceProgramgui {

   private static final int TRANSITION_DURATION = 250; // Duration for transition in milliseconds

    public static void showBuildingDetails(Stage primaryStage) {
        // Create BorderPane layout
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: royalblue; -fx-padding: 20px;");

        // Load images
        List<ImageWithCaptions> images = new ArrayList<>();
        images.add(new ImageWithCaptions("/photos/ComputerScienceProgram/yearonecuriculm.png", "As a freshman you will be introduced to Java, Learn about the Structure of code and be able to fulfill general education requirements"));
        images.add(new ImageWithCaptions("/photos/ComputerScienceProgram/yeartwocuriculm.png", "As a Sophmore "));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Arcidi.png", "Arcidi Center: Tour Check In Point"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/BowlingAlley.png", "Bowling Alley in the Student Union"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Mcquade.png", "McQuade Library"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Sak.png", "Sakowich Campus Center"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Sparky's.png", "Sparky's: Main Dining Hall On Campus"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Den.png", "Warrior's Den: Another Dining Option Within The Sakowich Center"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Gym.png", "Gym"));

        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setImage(images.get(0).getImage()); // Set initial image

        // Bind fit width and height of ImageView to size of BorderPane's center region
        imageView.fitWidthProperty().bind(root.widthProperty().divide(1.5));
        imageView.fitHeightProperty().bind(root.heightProperty().divide(1.5));

        // Create StackPane to overlay caption on ImageView
        StackPane imageStackPane = new StackPane();
        imageStackPane.getChildren().add(imageView);

        // Create caption label
        Label captionLabel = new Label();
        captionLabel.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7); -fx-padding: 5px;");
        captionLabel.setWrapText(true); // Wrap text if it exceeds the width
        captionLabel.prefWidthProperty().bind(imageView.fitWidthProperty()); // Set label width to fit ImageView width

        // Bind caption label position to image position
        StackPane.setAlignment(captionLabel, Pos.BOTTOM_CENTER);

        // Set initial caption
        captionLabel.setText(images.get(0).getCaption());

        imageStackPane.getChildren().add(captionLabel);

        // Create navigation buttons
        VBox leftNavButtons = createLeftNavigationButtons(images, imageView, captionLabel, caption -> {
            captionLabel.setText(caption);
            System.out.println("Displayed caption: " + caption);
            // Add custom logic here if needed
        });

        VBox rightNavButtons = createRightNavigationButtons(images, imageView, captionLabel, caption -> {
            captionLabel.setText(caption);
            System.out.println("Displayed caption: " + caption);
            // Add custom logic here if needed
        });
        VBox topRightButtons = createTopRightButtons(primaryStage);
        leftNavButtons.setAlignment(Pos.CENTER);
        rightNavButtons.setAlignment(Pos.CENTER);
        leftNavButtons.setSpacing(20);
        rightNavButtons.setSpacing(20);
        BorderPane.setAlignment(leftNavButtons, Pos.CENTER_LEFT);
        BorderPane.setAlignment(rightNavButtons, Pos.CENTER_RIGHT);

        root.setCenter(imageStackPane); // Use StackPane containing ImageView and caption label
        root.setLeft(leftNavButtons);
        root.setRight(rightNavButtons);
        root.setTop(topRightButtons); // Set top right buttons

        Scene scene = new Scene(root, 800, 500); // Initial scene size
        primaryStage.setScene(scene);
        primaryStage.setTitle("Slideshow with Captions");
        primaryStage.show();

        // Load images in a separate thread to avoid blocking the UI
        new Thread(() -> {
            for (ImageWithCaptions image : images) {
                try {
                    Thread.sleep(1000); // Simulate delay for loading each image
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Update UI on JavaFX Application Thread
                Platform.runLater(() -> {
                    imageView.setImage(image.getImage());
                    captionLabel.setText(image.getCaption());
                });
            }
        }).start();
    }

    private static VBox createTopRightButtons(Stage primaryStage) {
        VBox topRightButtons = new VBox();
        topRightButtons.setStyle("-fx-background-color: transparent;");

        // Create goback button
        Button goback = new Button("Return to Building Options");
        goback.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");
        goback.setOnAction(event -> {
            BuildingOptionsGUI buildingOptionsGUI = new BuildingOptionsGUI();
            buildingOptionsGUI.start(primaryStage);
        });

        topRightButtons.getChildren().add(goback);
        topRightButtons.setAlignment(Pos.TOP_RIGHT);
        return topRightButtons;
    }

    private static VBox createLeftNavigationButtons(List<ImageWithCaptions> images, ImageView imageView, Label captionLabel, BuildingDetailsListener listener) {
        VBox navButtons = new VBox();
        navButtons.setStyle("-fx-background-color: transparent;");

        // Create left button
        Button leftButton = new Button("←");
        leftButton.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");
        leftButton.setOnAction(event -> {
            int currentIndex = getCurrentIndex(images, imageView.getImage());
            if (currentIndex > 0) {
                ImageWithCaptions newImage = images.get(currentIndex - 1);
                Image image = new Image(newImage.getUrl()); // Correct way to create Image from URL
                imageView.setImage(image);
                applyFadeTransition(imageView, true);
                listener.onImageDisplayedChanged(newImage.getCaption()); // Notify listener with the new caption
            }
        });

        navButtons.getChildren().add(leftButton);
        return navButtons;
    }

    private static VBox createRightNavigationButtons(List<ImageWithCaptions> images, ImageView imageView, Label captionLabel, BuildingDetailsListener listener) {
        VBox navButtons = new VBox();
        navButtons.setStyle("-fx-background-color: transparent;");

        // Create right button
        Button rightButton = new Button("→");
        rightButton.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");
        rightButton.setOnAction(event -> {
            int currentIndex = getCurrentIndex(images, imageView.getImage());
            if (currentIndex < images.size() - 1) {
                ImageWithCaptions newImage = images.get(currentIndex + 1);
                Image image = new Image(newImage.getUrl()); // Correct way to create Image from URL
                imageView.setImage(image);
                applyFadeTransition(imageView, false);
                listener.onImageDisplayedChanged(newImage.getCaption()); // Notify listener with the new caption
            }
        });

        navButtons.getChildren().add(rightButton);
        return navButtons;
    }

    private static int getCurrentIndex(List<ImageWithCaptions> images, Image currentImage) {
        for (int i = 0; i < images.size(); i++) {
            if (images.get(i).getImage().getUrl().equals(currentImage.getUrl())) {
                return i;
            }
        }
        return -1;
    }

    private static void applyFadeTransition(ImageView imageView, boolean isLeft) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(TRANSITION_DURATION), imageView);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);

        TranslateTransition translateTransition;
        if (isLeft) {
            translateTransition = new TranslateTransition(Duration.millis(TRANSITION_DURATION), imageView);
            translateTransition.setToX(-imageView.getFitWidth() / 2);
        } else {
            translateTransition = new TranslateTransition(Duration.millis(TRANSITION_DURATION), imageView);
            translateTransition.setToX(imageView.getFitWidth() / 2);
        }

        ParallelTransition parallelTransition = new ParallelTransition(fadeTransition, translateTransition);
        parallelTransition.setOnFinished(event -> {
            imageView.setOpacity(1.0); // Reset opacity after transition
            imageView.setTranslateX(0); // Reset translation after transition
        });

        parallelTransition.play();
    }
}

