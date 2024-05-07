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

public class fivetendetailsgui implements BuildingDetailsListener {
    private static final int TRANSITION_DURATION = 250; // Duration for transition in milliseconds
    private static volatile boolean threadRunning = false; // Flag to control the thread execution
    private static boolean isUpstairsMode = false; // Flag to track the current mode

    public static void showBuildingDetails(Stage primaryStage, String buildingName) {
        // Create BorderPane layout
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: royalblue; -fx-padding: 20px;");
    
        // Load images
        List<ImageWithCaptions> upstairsimages = new ArrayList<>();
        upstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor2.png", "Hallyway straight through the doors and location of the bathrooms"));
        upstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor3.png", "Located to the right after the doors and location of classroom 202"));
        upstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor4.png", "Classroom 202: Electrical Engineering Labatory"));
        upstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor5.png", "Hallway located to the left after the doors"));
        upstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor6.png", "Offices of staff within the School of Engineering and a confrence room"));
        upstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor7.png", "Hallway to the right leading to more offices"));
        upstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor8.png", "Offices of staff withing the school of Engineering and Computational Sciences along with a study area"));
        upstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor10.png", "Another view of the study area"));
        upstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor11.png", "Additional Offices"));
        upstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor12.png", "Hallway back to stairs and the other entrance to the bathrooms"));

        List<ImageWithCaptions> downstairsimages = new ArrayList<>();
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Entrance.png", "Welcome to 510, home of the School of Computational Sciences!"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor1.png", "Main entrance doors"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor2.png", "Hallway straight through the main entrance and location of the bathrooms"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor3.png", "Rear entrance of the building and location of the stairs to the second floor"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor4.png", "Hallyway to right and location of the Mack Mart on East Campus"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor5.png", "Downstairs lobby area and location of the downstairs classrooms"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs Part 2-20240506T190054Z-001/CSC2620 Campus Photos Downstairs Part 2/510Lowerfloor7.png", "Classroom 103"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor6.png", "View of the lobby from classroom 103"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs Part 2-20240506T190054Z-001/CSC2620 Campus Photos Downstairs Part 2/510Lowerfloor10.png", "Project workshop area for collaborative work among students"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor11.png", "Lobby area in fromnt of classroom 105"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor12.png", "Classroom 105"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor13.png", "Other entrance to classroom 105"));
        downstairsimages.add(new ImageWithCaptions("/photos/CSC2620 Campus Photos Downstairs-20240506T185853Z-001/CSC2620 Campus Photos Downstairs/510Lowerfloor14.png","Hallway to the main entrance"));

        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setImage(downstairsimages.get(0).getImage()); // Set initial image

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
    captionLabel.setText(downstairsimages.get(0).getCaption());

    imageStackPane.getChildren().add(captionLabel);

    // Create navigation buttons
    VBox leftNavButtons = createLeftNavigationButtons(downstairsimages, imageView, captionLabel, caption -> {
        captionLabel.setText(caption);
        System.out.println("Displayed caption: " + caption);
        // Add custom logic here if needed
    });

    VBox rightNavButtons = createRightNavigationButtons(downstairsimages, imageView, captionLabel, caption -> {
        captionLabel.setText(caption);
        System.out.println("Displayed caption: " + caption);
        // Add custom logic here if needed
    });

    
        VBox Goback = createGobackButton(primaryStage);
        Goback.setAlignment(Pos.CENTER);
        leftNavButtons.setAlignment(Pos.CENTER);
        rightNavButtons.setAlignment(Pos.CENTER);
        leftNavButtons.setSpacing(20);
        rightNavButtons.setSpacing(20);
        BorderPane.setAlignment(leftNavButtons, Pos.CENTER_LEFT);
        BorderPane.setAlignment(rightNavButtons, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(Goback, Pos.BASELINE_CENTER);
    
        // Create mode switching buttons
        Button goUpstairsButton = new Button("Go Upstairs");
        goUpstairsButton.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");
        Button goDownstairsButton = new Button("Go Downstairs");
        goDownstairsButton.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");
    
        VBox bottomPane = new VBox();
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.getChildren().add(goUpstairsButton); // Add the "Go Upstairs" button initially
        bottomPane.getChildren().add(Goback);
        root.setBottom(bottomPane);
    
        // Add ImageView and navigation buttons to BorderPane
        root.setCenter(imageStackPane); // Use StackPane containing ImageView and caption label
        root.setLeft(leftNavButtons);
        root.setRight(rightNavButtons);
        root.setBottom(bottomPane);
    
        goUpstairsButton.setOnAction(event -> {
            bottomPane.getChildren().remove(goUpstairsButton); // Remove the "Go Upstairs" button
            bottomPane.getChildren().add(goDownstairsButton); // Add the "Go Downstairs" button
    
        isUpstairsMode = true;
        imageView.setImage(upstairsimages.get(0).getImage()); // Set initial image to the first upstairs image
        configureNavButtons(leftNavButtons, rightNavButtons, upstairsimages, imageView, captionLabel, new BuildingDetailsListener() {
            @Override
            public void onImageDisplayedChanged(String caption) {
                captionLabel.setText(caption); // Update the caption
                System.out.println("Displayed caption: " + caption);
            }
        }); // Update navigation buttons
    });
    
        goDownstairsButton.setOnAction(event -> {
            bottomPane.getChildren().remove(goDownstairsButton); // Remove the "Go Downstairs" button
            bottomPane.getChildren().add(goUpstairsButton); // Add the "Go Upstairs" button
    
            isUpstairsMode = false;
        imageView.setImage(downstairsimages.get(0).getImage()); // Set initial image to the first downstairs image
        configureNavButtons(leftNavButtons, rightNavButtons, downstairsimages, imageView, captionLabel, new BuildingDetailsListener() {
            @Override
            public void onImageDisplayedChanged(String caption) {
                captionLabel.setText(caption); // Update the caption
            System.out.println("Displayed caption: " + caption);
            // Add custom logic here if needed
            }
        }); // Update navigation buttons
    });

    
        // Create a Scene
        Scene scene = new Scene(root, 800, 500); // Initial scene size
    
        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle(buildingName + " Details");
        primaryStage.show();
    
        // Keep the fivetendetailsguiDecorator open in a separate thread
        new Thread(() -> {
            threadRunning = true; // Start the thread
            while (threadRunning) {
                try {
                    Thread.sleep(5000); // Adjust the sleep time according to your needs
                    Platform.runLater(() -> checkForImageChange(primaryStage, imageView, buildingName));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    private static void configureNavButtons(VBox leftNavButtons, VBox rightNavButtons, List<ImageWithCaptions> images, ImageView imageView, Label captionLabel, BuildingDetailsListener listener) {
        // Clear existing buttons
        leftNavButtons.getChildren().clear();
        rightNavButtons.getChildren().clear();
    
        // Create new navigation buttons
        VBox newLeftNavButtons = createLeftNavigationButtons(images, imageView, captionLabel, listener);
        VBox newRightNavButtons = createRightNavigationButtons(images, imageView, captionLabel, listener);
    
        // Set alignment and spacing
        newLeftNavButtons.setAlignment(Pos.CENTER);
        newRightNavButtons.setAlignment(Pos.CENTER);
        newLeftNavButtons.setSpacing(20);
        newRightNavButtons.setSpacing(20);
    
        // Add new navigation buttons to the provided containers
        leftNavButtons.getChildren().addAll(newLeftNavButtons.getChildren());
        rightNavButtons.getChildren().addAll(newRightNavButtons.getChildren());
    

        // Set alignment and spacing
        newLeftNavButtons.setAlignment(Pos.CENTER);
        newRightNavButtons.setAlignment(Pos.CENTER);
        newLeftNavButtons.setSpacing(20);
        newRightNavButtons.setSpacing(20);

        // Add new navigation buttons to the provided containers
        leftNavButtons.getChildren().addAll(newLeftNavButtons.getChildren());
        rightNavButtons.getChildren().addAll(newRightNavButtons.getChildren());
    }


    // Method to check for image change
    private static void checkForImageChange(Stage primaryStage, ImageView imageView, String buildingName) {
        // TODO Auto-generated method stub
    }

    // Method to create the "Return to Building Options" button
    private static VBox createGobackButton(Stage primaryStage) {
        VBox navButtons = new VBox();
        navButtons.setStyle("-fx-background-color: transparent;");

        // Create goback button
        Button goback = new Button("Return to Building Options");
        goback.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");
        goback.setOnAction(event -> {
            BuildingOptionsGUI buildingOptionsGUI = new BuildingOptionsGUI();
            buildingOptionsGUI.start(primaryStage);
            threadRunning = false; // Stop the thread when returning to building options
        });

        navButtons.getChildren().add(goback);
        return navButtons;
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

    // Helper method to get current index of the displayed image
    private static int getCurrentIndex(List<ImageWithCaptions> images, Image currentImage) {
        for (int i = 0; i < images.size(); i++) {
            if (images.get(i).getImage().getUrl().equals(currentImage.getUrl())) {
                return i;
            }
        }
        return -1;
    }
   
    // Method to apply fade transition to the image
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

    @Override
    public void onImageDisplayedChanged(String imagePath) {
        // Implement the logic to handle the change in displayed image
        System.out.println("Displayed image changed: " + imagePath);
        // You can add your own custom logic here, such as updating UI components, etc.
    }
    
}

interface BuildingDetailsListener {
    void onImageDisplayedChanged(String imagePath);
}
