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

    public fivetendetailsguiDecorator(fivetendetailsgui fivetendetailsgui) {
        this.fivetendetailsgui = fivetendetailsgui;
    }

    @Override
    public void showBuildingDetails(Stage primaryStage, String buildingName) {
        // Call the original showBuildingDetails method
        fivetendetailsgui.showBuildingDetails(primaryStage, buildingName);

        // Add MC logo overlay and pop-up functionality
        addMCLogoOverlay(primaryStage);
    }

    private void addMCLogoOverlay(Stage primaryStage) {
        // Get the root BorderPane from the primaryStage
        BorderPane root = (BorderPane) primaryStage.getScene().getRoot();

        // Create overlay pane
        AnchorPane overlay = new AnchorPane();

        // MC logo image
        Image mcLogoImage = new Image("mavenproject1\\target\\classes\\photos\\mclogo.png");
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
}
