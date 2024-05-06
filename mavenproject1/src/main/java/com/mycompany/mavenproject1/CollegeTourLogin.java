package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CollegeTourLogin extends Application {

    private static final String JSON_FILE_PATH = "users.json";

    @Override
    public void start(Stage primaryStage) {
        Parent root = getRoot(primaryStage);
    }

    public Parent getRoot(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Button skipButton = new Button("Skip");
        skipButton.setOnAction(e -> {
            exitApplication(primaryStage);
        });

        String email = promptForValidEmail();
        if (email.isEmpty()) {
            exitApplication(primaryStage);
            return root;
        }

        if (userExistsByEmail(email)) {
            showAlert("Welcome Back!", "Welcome back to the Merrimack Computer Science Interactive Tour!", Alert.AlertType.INFORMATION);
            Mavenproject1 mavenproject1 = new Mavenproject1();
            mavenproject1.start(primaryStage);
            return root;
        }

        String name = promptForInput("Name:", "Please provide your name:");
        if (name.isEmpty()) {
            exitApplication(primaryStage);
            return root;
        }

        String location = promptForInput("Location:", "Please provide your location:");
        if (location.isEmpty()) {
            exitApplication(primaryStage);
            return root;
        }

        String role = promptForInput("Role:", "Please specify your role (student/parent/other):");
        if (role.isEmpty()) {
            exitApplication(primaryStage);
            return root;
        }

        String grade = "";
        if ("student".equalsIgnoreCase(role)) {
            grade = promptForInput("Grade:", "Please provide your grade:");
            if (grade.isEmpty()) {
                Mavenproject1 mavenproject1 = new Mavenproject1();
                mavenproject1.start(primaryStage);
                return root;
            }
        }

        System.out.println("Welcome to your Merrimack Computer Science Interactive Tour!");

        appendUserToJsonFile(name, location, role, grade, email);
        System.out.println("User information appended to users.json file.");

        exitApplication(primaryStage);

        return root;
    }

    private void exitApplication(Stage primarStage) {  
        Mavenproject1 mavenproject1 = new Mavenproject1();
        mavenproject1.start(primarStage);

    }
    
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean userExistsByEmail(String email) {
        try {
            Path filePath = Paths.get(JSON_FILE_PATH);
            if (!Files.exists(filePath)) {
                return false;
            }

            String fileContent = new String(Files.readAllBytes(filePath));
            JSONArray jsonArray = new JSONArray(fileContent);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String userEmail = jsonObject.getString("email");
                if (userEmail.equalsIgnoreCase(email)) {
                    return true;
                }
            }

            return false;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String promptForInput(String title, String header) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("College Tour Login");
        dialog.setHeaderText(header);
        dialog.setContentText(title);
        Optional<String> result = dialog.showAndWait();
        return result.orElse("");
    }

    private String promptForValidEmail() {
        String email = "";
        boolean isValid = false;

        while (!isValid) {
            TextInputDialog emailDialog = new TextInputDialog();
            emailDialog.setTitle("College Tour Login");
            emailDialog.setHeaderText("Please provide your contact email:");
            emailDialog.setContentText("Email:");

            Optional<String> emailResult = emailDialog.showAndWait();
            if (emailResult.isPresent()) {
                email = emailResult.get();
                isValid = isValidEmail(email);

                if (!isValid) {
                    showAlert("Invalid Email", "Please provide a valid email address.", Alert.AlertType.ERROR);
                }
            } else {
                break;
            }
        }

        return email;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void appendUserToJsonFile(String name, String location, String role, String grade, String email) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(JSON_FILE_PATH, "rw")) {
            if (randomAccessFile.length() == 0) {
                try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
                    fileWriter.write("[\n");
                }
            }

            if (randomAccessFile.length() > 2) {
                randomAccessFile.seek(randomAccessFile.length() - 2);
            }

            randomAccessFile.writeBytes(",\n");
            randomAccessFile.writeBytes("{\n");
            randomAccessFile.writeBytes("  \"name\": \"" + name + "\",\n");
            randomAccessFile.writeBytes("  \"location\": \"" + location + "\",\n");
            randomAccessFile.writeBytes("  \"email\": \"" + email + "\",\n");
            randomAccessFile.writeBytes("  \"role\": \"" + role + "\"");
            if ("student".equalsIgnoreCase(role)) {
                randomAccessFile.writeBytes(",\n  \"grade\": \"" + grade + "\"\n");
            } else {
                randomAccessFile.writeBytes("\n");
            }
            randomAccessFile.writeBytes("}\n");

            if (randomAccessFile.length() > 2) {
                randomAccessFile.writeBytes("]\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
