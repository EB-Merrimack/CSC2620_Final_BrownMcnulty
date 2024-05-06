package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BuildingOptionsGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        Mavenproject1 mainMenu = new Mavenproject1(); // Create an instance of the main menu

        // Create checkboxes for Main Campus and East Campus
        RadioButton mainCampusCheckbox = new RadioButton("Main Campus");
        RadioButton eastCampusCheckbox = new RadioButton("East Campus");

        // Create a ToggleGroup to ensure only one radio button can be selected at a time
        ToggleGroup toggleGroup = new ToggleGroup();
        mainCampusCheckbox.setToggleGroup(toggleGroup);
        eastCampusCheckbox.setToggleGroup(toggleGroup);

        // Create a VBox to hold the checkboxes
        VBox checkboxBox = new VBox(10);
        checkboxBox.setAlignment(Pos.CENTER);
        checkboxBox.setPadding(new Insets(20));
        checkboxBox.getChildren().addAll(mainCampusCheckbox, eastCampusCheckbox);

        // Create placeholder text
        Text placeholderText = new Text("Click which campus you would like to learn about first");
        placeholderText.setStyle("-fx-fill: gold;");
        placeholderText.setFont(Font.font("Arial Black", 16)); // Setting font for better effect

        // Apply glow effect to mimic neon effect
        Glow glow = new Glow(0.8);
        placeholderText.setEffect(glow);

        // Set maximum width for the text to ensure it fits within the viewable area
        placeholderText.setWrappingWidth(300);

        // Create a StackPane to hold the placeholder text with background
        StackPane placeholderPane = new StackPane();
        placeholderPane.getChildren().add(placeholderText);
        placeholderPane.setStyle("-fx-background-color: royalblue; -fx-background-radius: 10px; -fx-padding: 10px;");

        // Create a button for the interactive building tour
        Button tourButton = new Button("Take Interactive Tour");
        tourButton.setVisible(false); // Initially, the button is invisible

        // Add event handlers for checkboxes
        mainCampusCheckbox.setOnAction(e -> {
            if (mainCampusCheckbox.isSelected()) {
                placeholderText.setText(new MainCampusInfo().getInfo());
                tourButton.setOnAction(event -> {
                    // Perform actions specific to Main Campus interactive tour
                    System.out.println("Initiating Main Campus interactive tour...");
                });
                tourButton.setVisible(true); // Show the button when Main Campus checkbox is selected
            }
        });

        eastCampusCheckbox.setOnAction(e -> {
            if (eastCampusCheckbox.isSelected()) {
                placeholderText.setText(new EastCampusInfo().getInfo());
                tourButton.setOnAction(event -> {
                    // Perform actions specific to East Campus interactive tour
                    System.out.println("Initiating East Campus interactive tour...");
                    fivetendetailsgui.showBuildingDetails(primaryStage, "East Campus");
                });
                tourButton.setVisible(true); // Show the button when East Campus checkbox is selected
            }
        });

        // Add event handler for the "Go Back to Main Menu" button
        Button backButton = new Button("Go Back to Main Menu");
        backButton.setOnAction(event -> {
            mainMenu.start(primaryStage); // Go back to the main menu
        });

        // Create a VBox to hold the buttons
        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(tourButton, backButton);

        // Create a BorderPane to organize the layout
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(checkboxBox);
        borderPane.setCenter(placeholderPane);
        borderPane.setBottom(buttonBox);
        BorderPane.setAlignment(placeholderPane, Pos.CENTER);
        BorderPane.setAlignment(buttonBox, Pos.CENTER);

        // Create a Scene
        Scene scene = new Scene(borderPane, 500, 400);

        // Set the scene and show the stage
        primaryStage.setTitle("Building Options");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
