package com.example.best_movies;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML file for the table view
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tableview.fxml"));
            // Create a new scene with the loaded FXML content
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);

            // Set the image as the window icon
            Image icon = new Image(getClass().getResourceAsStream("/images/logo.png"));
            stage.getIcons().add(icon);

            // Set the title of the stage
            stage.setTitle("Movies Database");
            // Set the scene to the stage
            stage.setScene(scene);
            // Show the stage
            stage.show();
        } catch (IOException e) {
            // Print the stack trace if an IO exception occurs
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }
}
