package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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
        // Create checkboxes for Main Campus and East Campus
        CheckBox mainCampusCheckbox = new CheckBox("Main Campus");
        CheckBox eastCampusCheckbox = new CheckBox("East Campus");

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

        // Create a BorderPane to organize the layout
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(checkboxBox);
        borderPane.setCenter(placeholderPane);
        BorderPane.setAlignment(placeholderPane, Pos.CENTER);

        // Create a Scene
        Scene scene = new Scene(borderPane, 500, 300);

        // Set the scene and show the stage
        primaryStage.setTitle("Building Options");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Decorator objects
        BuildingInfo mainCampusInfo = new MainCampusInfo();
        BuildingInfo eastCampusInfo = new EastCampusInfo();

        // Add event handlers for checkboxes
        mainCampusCheckbox.setOnAction(e -> {
            if (mainCampusCheckbox.isSelected()) {
                System.out.println(new BuildingInfoDecorator(mainCampusInfo).getInfo());
            }
        });

        eastCampusCheckbox.setOnAction(e -> {
            if (eastCampusCheckbox.isSelected()) {
                System.out.println(new BuildingInfoDecorator(eastCampusInfo).getInfo());
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
