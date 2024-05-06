package com.mycompany.mavenproject1;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class fivetendetailsguiDecorator implements fivetenupstairsinfo {
    private fivetendetailsgui fivetendetailsgui;
    private BuildingDetailsListener buildingDetailsListener;

    public fivetendetailsguiDecorator(fivetendetailsgui fivetendetailsgui) {
        this.fivetendetailsgui = fivetendetailsgui;
    }

    @Override
    public void showBuildingDetails(Stage primaryStage, String buildingName) {
        // Call the original showBuildingDetails method
        fivetendetailsgui.showBuildingDetails(primaryStage, buildingName);

        // Check if the specified image is displayed
        Image specifiedImage = new Image("/photos/CSC2620 Campus Photos Upstairs-20240430T003439Z-001/CSC2620 Campus Photos Upstairs/510upperfloor2.png");
        if (isImageDisplayed(primaryStage, specifiedImage)) {
            System.out.println("Specified image is displayed.");
            // Notify listener of image change
            notifyImageDisplayedChanged(specifiedImage.getUrl());
            // Add MC logo overlay and pop-up functionality
            addMCLogoOverlay(primaryStage);
        } else {
            System.out.println("Specified image is NOT displayed.");
        }
    }

    private boolean isImageDisplayed(Stage primaryStage, Image image) {
        BorderPane root = (BorderPane) primaryStage.getScene().getRoot();
        ImageView imageView = (ImageView) root.getCenter();
        boolean result = imageView.getImage().equals(image);
        System.out.println("Image displayed: " + result);
        return result;
    }

    private void addMCLogoOverlay(Stage primaryStage) {
        // Get the root BorderPane from the primaryStage
        BorderPane root = (BorderPane) primaryStage.getScene().getRoot();

        // Create overlay pane
        AnchorPane overlay = new AnchorPane();

        // MC logo image
        Image mcLogoImage = new Image("/photos/mclogo.png"); // Update path
        ImageView mcLogo = new ImageView(mcLogoImage);
        mcLogo.setFitWidth(100); // Adjust size as needed
        mcLogo.setPreserveRatio(true);

        // Position MC logo in the top right corner
        AnchorPane.setTopAnchor(mcLogo, 10.0);
        AnchorPane.setRightAnchor(mcLogo, 10.0);

        // Add event handler to display welcome message on click
        mcLogo.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> displayWelcomeMessage(primaryStage));

        overlay.getChildren().add(mcLogo);

        // Add overlay to the root BorderPane
        root.getChildren().add(overlay);
    }

    private void displayWelcomeMessage(Stage primaryStage) {
        // Create VBox for pop-up message
        VBox messageBox = new VBox();
        messageBox.setStyle("-fx-background-color: white; -fx-padding: 20px;");
        messageBox.setSpacing(10);

        // Add text to VBox
        Text welcomeText = new Text("Welcome to the Upper Floor of FiveTen!\nHere you will find a bunch of different things.");
        welcomeText.setFont(Font.font(20));

        // Add text to VBox
        messageBox.getChildren().add(welcomeText);

        // Create new stage for pop-up message
        Stage messageStage = new Stage();
        messageStage.initOwner(primaryStage);
        messageStage.initModality(Modality.WINDOW_MODAL);

        // Set scene with VBox
        Scene messageScene = new Scene(messageBox);
        messageStage.setScene(messageScene);

        // Show pop-up message
        messageStage.show();
    }

    @Override
    public void setBuildingDetailsListener(BuildingDetailsListener listener) {
        this.buildingDetailsListener = listener;
    }

    private void notifyImageDisplayedChanged(String imagePath) {
        if (buildingDetailsListener != null) {
            buildingDetailsListener.onImageDisplayedChanged(imagePath);
        }
    }
}
