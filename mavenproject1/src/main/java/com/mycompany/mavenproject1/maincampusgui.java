package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The maincampusgui class is responsible for displaying details about Merrimack's main campus.
 * It loads images with captions representing different aspects of the program and displays them in a slideshow format.
 */
public class maincampusgui {
    private static final int TRANSITION_DURATION = 250; // Duration for transition in milliseconds
    private static volatile boolean threadRunning = true;
    private static Thread slideshowThread;
    /**
     * Shows building details with a slideshow of images and captions.
     *
     * @param  primaryStage  the primary stage for the JavaFX application
     * @param  buildingName  the name of the building for which details are shown
     */
    public static void showBuildingDetails(Stage primaryStage, String buildingName) {
        // Create BorderPane layout
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: royalblue; -fx-padding: 20px;");

        // Load images
        List<ImageWithCaptions> images = new ArrayList<>();
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/MapOfCampus.png", "Map of main campus"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Entrance.png", "Campus Entrance"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Arcidi.png", "Arcidi Center: Tour Check In Point"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/StudentUnion.png", "Student Union: Location of Monica's Kitchen, the bowling alley, esports center, and the Collegiate church of Christ the Teacher "));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/BowlingAlley.png", "Bowling Alley in the Student Union"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Mcquade.png", "McQuade Library: Location of the Mack Mart, tech bar, O'brien Center, math and writing centers, and accessibilities services"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Sak.png", "Sakowich Campus Center"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Sparky's.png", "Sparky's: Main Dining Hall On Campus"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Den.png", "Warrior's Den: Another Dining Option Within The Sakowich Center"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Gym.png", "Gym"));
        images.add(new ImageWithCaptions("/photos/CSC2620 Main Campus-20240506T193717Z-001/CSC2620 Main Campus/Hub.png", "The Hub: The office of student involvement"));

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


// Assuming captionLabel is a Text node and images is a List<ImageWithCaptions>
// Assuming captionLabel is a Label node and images is a List<ImageWithCaptions>
String styledCaption = images.get(0).getCaption();
captionLabel.setStyle("-fx-text-fill: royalblue; -fx-font-weight: bold; -fx-font-family: Arial; -fx-font-size: 14px;");
DropShadow dropShadow = new DropShadow();
dropShadow.setColor(Color.DARKGRAY);
dropShadow.setRadius(3);
dropShadow.setOffsetX(2);
dropShadow.setOffsetY(2);
captionLabel.setEffect(dropShadow);
captionLabel.setBackground(new Background(new BackgroundFill(Color.rgb(255, 215, 0 ,.5), new CornerRadii(5), Insets.EMPTY))); // Semi-transparent background color
captionLabel.setText(styledCaption);
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

        Scene scene = new Scene(root, 1000, 600); // Initial scene size
        primaryStage.setScene(scene);
        primaryStage.setTitle("Slideshow with Captions");
        primaryStage.show();
      // Create a toggle button with play and pause icons
ToggleButton playPauseButton = new ToggleButton();
playPauseButton.setStyle("-fx-background-color: gold; -fx-font-size: 20px; -fx-padding: 10px;");


// Set play and pause icons to the button
playPauseButton.setText("pause"); // Set initial icon to pause

// Add action event handler to toggle between play and pause icons
playPauseButton.setOnAction(event -> {
    if (playPauseButton.isSelected()) {
        // Change to play icon and resume the slideshow thread
        playPauseButton.setText("play");
        threadRunning = false;
        synchronized (slideshowThread) {
            slideshowThread.notify(); // Notify the thread to resume execution
        }
    } else {
        // Change to pause icon and pause the slideshow thread
        playPauseButton.setText("Pause");
        threadRunning = true;
        synchronized (slideshowThread) {
            slideshowThread.notify(); // Notify the thread to resume execution
        }
    }
});

// Add the play/pause button to the control buttons HBox
HBox controlButtons = new HBox(playPauseButton);
controlButtons.setAlignment(Pos.CENTER);
controlButtons.setSpacing(20);

// Add control buttons to the BorderPane
root.setBottom(controlButtons);

        // Initialize and start the slideshow thread
         // Initialize and start the slideshow thread
         slideshowThread = new Thread(() -> {
            int[] currentIndex = {0}; // Array to hold the index
            while (threadRunning) {
                // Update UI on JavaFX Application Thread
                Platform.runLater(() -> {
                    ImageWithCaptions image = images.get(currentIndex[0]);
                    imageView.setImage(image.getImage());
                    captionLabel.setText(image.getCaption());
                });
                try {
                    Thread.sleep(5000); // Delay between image transitions
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentIndex[0] = (currentIndex[0] + 1) % images.size();
                // Check if the thread should be paused
                synchronized (slideshowThread) {
                    if (!threadRunning) {
                        try {
                            slideshowThread.wait(); // Pause the thread until notified
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        slideshowThread.start();
    }

        

    /**
     * Creates a VBox containing a button for returning to the Building Options GUI.
     *
     * @param  primaryStage  the primary stage for the JavaFX application
     * @return               a VBox containing the return button
     */
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

    /**
     * Creates a VBox containing a button for navigating to the previous image in the list of images.
     *
     * @param  images      a list of ImageWithCaptions objects representing the images to navigate through
     * @param  imageView   the ImageView to display the current image
     * @param  captionLabel the Label to display the caption of the current image
     * @param  listener     the BuildingDetailsListener to notify when the image is changed
     * @return             a VBox containing the left navigation button
     */
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

    /**
     * Creates a VBox containing a button for navigating to the next image in the list of images.
     *
     * @param  images      a list of ImageWithCaptions objects representing the images to navigate through
     * @param  imageView   the ImageView to display the current image
     * @param  captionLabel the Label to display the caption of the current image
     * @param  listener     the BuildingDetailsListener to notify when the image is changed
     * @return             a VBox containing the right navigation button
     */
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

    /**
     * A description of the entire Java function.
     *
     * @param  images      description of parameter
     * @param  currentImage description of parameter
     * @return             description of return value
     */
    private static int getCurrentIndex(List<ImageWithCaptions> images, Image currentImage) {
        for (int i = 0; i < images.size(); i++) {
            if (images.get(i).getImage().getUrl().equals(currentImage.getUrl())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Applies a fade transition to the given ImageView. The transition consists of a fade effect and a translation effect.
     *
     * @param  imageView   the ImageView to apply the transition to
     * @param  isLeft      true if the transition should move the image to the left, false if it should move to the right
     */
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
