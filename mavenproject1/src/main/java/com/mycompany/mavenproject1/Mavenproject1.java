package com.mycompany.mavenproject1;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Mavenproject1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the initial scene
        createInitialScene(primaryStage);

    }

    // Method to create the initial scene
    private void createInitialScene(Stage primaryStage) {
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

        // Create a rectangle with gradient fill for sparkling effect
        Rectangle rectangle = new Rectangle(500, 100);
        root.setAlignment(Pos.BOTTOM_CENTER);
        rectangle.setFill(Color.ROYALBLUE); // Set the fill to transparent
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.ROYALBLUE), new Stop(0.5, Color.GOLD), new Stop(1, Color.ROYALBLUE));
        rectangle.setStroke(linearGradient); // Set the stroke with gradient color
        rectangle.setStrokeWidth(7); // Set the stroke width
        rectangle.setArcWidth(20); // Set arc width for rounded corners
        rectangle.setArcHeight(20); // Set arc height for rounded corners
        root.getChildren().add(rectangle);

        // Create a Text node for "Continue"
        Text continueText = new Text("Press To Start Your Tour");
        continueText.setFont(Font.font("Arial", FontWeight.BOLD, 30)); // Set font and size
        continueText.setFill(Color.WHITE); // Set text color

        // Add the Text node to the StackPane
        StackPane.setAlignment(continueText, Pos.BOTTOM_CENTER);
        StackPane.setMargin(continueText, new Insets(20)); // Adjust margin if needed
        root.getChildren().add(continueText);

        // Create TranslateTransition for sparkling effect
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(5), rectangle);
        translateTransition.setCycleCount(Animation.INDEFINITE);
        translateTransition.setAutoReverse(true);
        translateTransition.play();

        // Create FadeTransition for sparkling effect
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5), rectangle);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.4);
        fadeTransition.play();

        // Add event handler to the rectangle
       // Add event handler to the "Continue" text
continueText.setOnMouseClicked(e -> {
    // Handle the event when the "Continue" text is clicked
    BuildingOptionsGUI buildingOptionsGUI = new BuildingOptionsGUI();
    buildingOptionsGUI.start(primaryStage);
});


        // Create a Scene
        Scene scene = new Scene(root, 800, 600);

        // Set the scene and show the stage
        primaryStage.setTitle("Merrimack Computer Science Campus Tour");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
