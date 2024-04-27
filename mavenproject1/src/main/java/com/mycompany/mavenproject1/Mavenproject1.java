package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author emily
 */
public class Mavenproject1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label
        Label label = new Label("");

        // Create an ImageView to display the image
        Image image = new Image("https://www.merrimack.edu/wp-content/uploads/DSC8310-2-scaled.jpg");
        ImageView imageView = new ImageView(image);

        // Bind fit width and height properties to the scene width and height
        imageView.fitWidthProperty().bind(primaryStage.widthProperty());
        imageView.fitHeightProperty().bind(primaryStage.heightProperty());

        // Create a StackPane to hold the label and the image
        StackPane root = new StackPane();
        root.getChildren().addAll(imageView, label);

        // Create a Scene
        Scene scene = new Scene(root, 300, 200);

        // Set the scene and show the stage
        primaryStage.setTitle("Merrimack Computer Science Campus Tour");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
