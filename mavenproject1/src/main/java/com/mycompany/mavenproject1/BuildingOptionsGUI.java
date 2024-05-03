package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuildingOptionsGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create checkboxes for Main Campus and East Campus
        CheckBox mainCampusCheckbox = new CheckBox("Main Campus");
        CheckBox eastCampusCheckbox = new CheckBox("East Campus");

        // Create a VBox to hold the checkboxes
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(mainCampusCheckbox, eastCampusCheckbox);

        // Create a Scene
        Scene scene = new Scene(vbox, 300, 200);

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
