package com.example.javaassigment1_200390696;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentCardApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StudentCardApplication.class.getResource("studentCardView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        /**
         * Set the logo in the taskbar and title bar
         * Free to use image from https://pixabay.com/vectors/cap-school-graduation-1266204/
         */
        stage.getIcons().add(new Image("graduationCap.png"));
        stage.setTitle("Student Card");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}