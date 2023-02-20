package com.example.javaassigment1_200390696;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.shape.Circle;
public class StudentCardController implements Initializable {
        @FXML
        private ListView<?> activityPane;

        @FXML
        private Circle imageCircle;

        @FXML
        private Button nextButton;

        @FXML
        private Label studentNameLabel;

        @FXML
        private Label studentNumLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}