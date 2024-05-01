package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuildingOptionsGUI extends Application {

    @SuppressWarnings("exports")
    @Override
    public void start(Stage primaryStage) {
        new fivetendetailsgui();

        // Create a label
        Label label = new Label("Choose the building you want to explore:");

        // Create buttons for different buildings
        Button building1Button = createBuildingButton(primaryStage, "east Campus: 510 and 530 Turnpike street", "https://images1.loopnet.com/i2/GdO6a0ARdeAnMqJhNF9KOKe8wC7qtg5hchexbrOypyM/110/510-Turnpike-St-North-Andover-MA-Primary-Photo-1-Large.jpg");
        Button building2Button = createBuildingButton(primaryStage, "Main Campus", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQz3aVGns1PtaylQoK0jV-wVHcFffWtR-czvfxsIBBE7w&s");

        // Create a VBox to hold the label and buttons
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(label, building1Button, building2Button);

        // Create a Scene
        Scene scene = new Scene(vbox, 600, 400);

        // Set the scene and show the stage
        primaryStage.setTitle("Building Options");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createBuildingButton(Stage primaryStage, String buildingName, String imageUrl) {
        Button button = new Button(buildingName);
        button.setOnAction(e -> showBuildingDetails(primaryStage, buildingName));
    
        // Load the image from URL
        Image image = new Image(imageUrl);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100); // Set image width
        imageView.setFitHeight(100); // Set image height
    
        // Create an HBox to hold the image and button text
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(imageView, button);
    
        return button;
    }
    
    private void showBuildingDetails(Stage primaryStage, String buildingName) {
        com.mycompany.mavenproject1.fivetendetailsgui.showBuildingDetails(primaryStage, buildingName);
    }

}
