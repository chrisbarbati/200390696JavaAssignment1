package com.example.javaassigment1_200390696;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
public class StudentCardController implements Initializable {

    @FXML
    private VBox activityHolder;

    @FXML
    private Circle imageCircle;

    @FXML
    private Button nextButton;

    @FXML
    private Label studentNameLabel;

    @FXML
    private Label studentNumLabel;

    private int currentStudent = 0;

    /**
     * ArrayList to hold the Student objects, so we can iterate over them easily later
     */
    private ArrayList<Student> studentsList;

    /**
     * Arraylist to hold the Label objects with which I will populate the activities on the card view
     */
    ArrayList<Label> labelList = new ArrayList<>();

    /**
     * Function to be called when the next button is pressed. Should move to next student item in studentList
     * and update the view accordingly.
     */
    private void nextCard(){
        currentStudent++;

        if(currentStudent >= studentsList.size()){
            currentStudent = 0;
        }

        /**
         * Remove all activities from the labelList, repopulate it with the current student's
         * favourite activities, and then populate the activityHolder VBox with the list items
         */
        labelList.removeAll(labelList);

        for(String activity : studentsList.get(currentStudent).getStudentActivities()){
            labelList.add(new Label(activity));
        }

        activityHolder.getChildren().setAll(labelList);

        /**
         * Update the other fields with the new student's data
         */
        studentNameLabel.setText("Name: " + studentsList.get(currentStudent).getFirstName() + " " + studentsList.get(currentStudent).getLastName());
        studentNumLabel.setText("Student Number: " + studentsList.get(currentStudent).getStudentNumber());
        imageCircle.setFill(new ImagePattern(studentsList.get(currentStudent).getStudentPicture()));
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * Add to the list of valid activities
         */
        Student.addValidActivity("Hiking");
        Student.addValidActivity("Swimming");
        Student.addValidActivity("Running");
        Student.addValidActivity("Coding");
        Student.addValidActivity("Soccer");
        Student.addValidActivity("Baseball");
        Student.addValidActivity("Basketball");
        Student.addValidActivity("Hockey");


        /**
         * Instantiate three student objects directly into studentsList ArrayList
         * Instantiated ArrayList and Image objects within the constructor to make code neater
         */

        studentsList = new ArrayList<>(Arrays.asList(

        new Student(
                new ArrayList<String>(Arrays.asList("Hiking", "Coding", "Running")),
                new Image("portrait1.jpg"),
                200390696,
                "Christian",
                "Barbati"
        ),

        /**
         * Jane Smith likes all the activities, in order to demonstrate the scrollPane
         * Image Attributions:
         * Anastasiya Gepp - https://www.pexels.com/photo/woman-standing-in-hallway-while-holding-book-1462630/
         * Buro Millenial - https://www.pexels.com/photo/selective-focus-photo-of-man-using-laptop-1438081/
         */
        new Student(
                new ArrayList<String>(Arrays.asList("Hiking", "Swimming", "Running", "Coding", "Soccer", "Baseball", "Basketball", "Hockey")),
                new Image("portrait2.jpg"),
                204353256,
                "Jane",
                "Smith"
        ),
        /**
        * Left some empty spaces and uncapitalized words in Matt Smith's name, to demonstrate setter functionality
        */
        new Student(
                new ArrayList<String>(Arrays.asList("Hiking", "Swimming", "Running")),
                new Image("portrait3.jpg"),
                149204124,
                "   matt   ",
                " baker    "
        )
        ));

        /**
         * Set the listener for the "next" button
         */
        nextButton.setOnMouseClicked(event -> nextCard());

        /**
         * Set the initial values for the studentCardView
         */
        studentNameLabel.setText("Name: " + studentsList.get(0).getFirstName() + " " + studentsList.get(0).getLastName());
        studentNumLabel.setText("Student Number: " + studentsList.get(0).getStudentNumber());
        imageCircle.setFill(new ImagePattern(studentsList.get(0).getStudentPicture()));

        /**
         * Fill the activity labels and populate them into the VBox
         */
        for(String activity : studentsList.get(currentStudent).getStudentActivities()){
            labelList.add(new Label(activity));
        }
        activityHolder.getChildren().setAll(labelList);
    }
}