package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The fivetendetailsgui class is responsible for displaying details about bulding 510.
 * It loads images with captions representing different aspects of the program and displays them in a slideshow format.
 */
public class fivetendetailsgui {
    private static final int TRANSITION_DURATION = 250; // Duration for transition in 
    
    /**
     * Displays the computer science program details in a JavaFX Stage.
     * This method sets up the layout, loads images with captions, and creates a slideshow.
     *
     * @param primaryStage The primary stage to display the program details.
     */
    public static void showBuildingDetails(Stage primaryStage, String buildingName) {
        // Create BorderPane layout
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: royalblue; -fx-padding: 20px;");
    
        // Load images
        List<ImageWithCaptions> upstairsimages = new ArrayList<>();
        upstairsimages.add(new ImageWithCaptions("photos/CSC2620 Extra Photos-20240507T164141Z-001/CSC2620 Extra Photos/510UpperrLevel1.PNG", "Entrance to the second floor at the top of the stairs"));
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

  // Assuming captionLabel is a Text node and images is a List<ImageWithCaptions>
String styledCaption = downstairsimages.get(0).getCaption();
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
    
      
        VBox toppane= new VBox();
       
        toppane.getChildren().addAll(goUpstairsButton,Goback); // Add the "Go Upstairs" button initially
        // Add ImageView and navigation buttons to BorderPane
        root.setCenter(imageStackPane); // Use StackPane containing ImageView and caption label
        root.setLeft(leftNavButtons);
        root.setRight(rightNavButtons);
        root.setTop(toppane);
    
        goUpstairsButton.setOnAction(event -> {
            toppane.getChildren().remove(goUpstairsButton); // Remove the "Go Upstairs" button
            toppane.getChildren().add(goDownstairsButton); // Add the "Go Downstairs" button
            captionLabel.setText(upstairsimages.get(0).getCaption());
    
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
            toppane.getChildren().remove(goDownstairsButton); // Remove the "Go Downstairs" button
            toppane.getChildren().add(goUpstairsButton); // Add the "Go Upstairs" button
            captionLabel.setText(downstairsimages.get(0).getCaption());
            imageView.setImage(downstairsimages.get(0).getImage()); // Set initial image to the first downstairs image
        configureNavButtons(leftNavButtons, rightNavButtons, downstairsimages, imageView, captionLabel, new BuildingDetailsListener() {
            
            @Override
            public void onImageDisplayedChanged(String caption) {
                captionLabel.setText(caption); // Update the caption
            System.out.println("Displayed caption: " + caption);
          
            }
        }); // Update navigation buttons
    });

    
        // Create a Scene
        Scene scene = new Scene(root, 800, 500); // Initial scene size
    
        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle(buildingName + " Details");
        primaryStage.show();
    
    }
    
    /**
     * Configures the navigation buttons for the given VBox containers.
     *
     * @param  leftNavButtons   the VBox container for the left navigation buttons
     * @param  rightNavButtons  the VBox container for the right navigation buttons
     * @param  images           the list of ImageWithCaptions objects representing the images to navigate through
     * @param  imageView        the ImageView to display the current image
     * @param  captionLabel     the Label to display the caption of the current image
     * @param  listener          the BuildingDetailsListener to notify when the image is changed
     */
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
        });

        navButtons.getChildren().add(goback);
        return navButtons;
    }

   

    /**
     * Creates a VBox containing a left navigation button. When the button is clicked, it navigates to the previous image in the list of images.
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
     * Creates a VBox containing a right navigation button. When the button is clicked, it navigates to the next image in the list of images.
     *
     * @param  images         a list of ImageWithCaptions objects representing the images to navigate through
     * @param  imageView      the ImageView to display the current image
     * @param  captionLabel   the Label to display the caption of the current image
     * @param  listener       the BuildingDetailsListener to notify when the image is changed
     * @return                a VBox containing the right navigation button
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

    
}


