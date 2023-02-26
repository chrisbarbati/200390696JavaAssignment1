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

        //Clear the prior activities
        labelList.removeAll(labelList);

        //Fill the activities
        for(String activity : studentsList.get(currentStudent).getStudentActivities()){
            labelList.add(new Label(activity));
        }
        activityHolder.getChildren().setAll(labelList);

        studentNameLabel.setText("Name: " + studentsList.get(currentStudent).getFirstName() + " " + studentsList.get(currentStudent).getLastName());
        studentNumLabel.setText("Student Number: " + studentsList.get(currentStudent).getStudentNumber());
        imageCircle.setFill(new ImagePattern(studentsList.get(currentStudent).getStudentPicture()));
        }

    private ArrayList<Student> studentsList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * Add to the list of valid activities
         */
        Student.addValidActivity("Hiking");
        Student.addValidActivity("Swimming");
        Student.addValidActivity("Running");
        Student.addValidActivity("Sports");
        Student.addValidActivity("Coding");
        Student.addValidActivity("Gaming");

        /**
         * Initialize a student (testing view, come back to this later to clean up implementation
         */
        ArrayList studentActivities = new ArrayList();
        studentActivities.add("Swimming");
        studentActivities.add("Swimming");
        studentActivities.add("Swimming");
        studentActivities.add("Swimming");
        studentActivities.add("Swimming");
        studentActivities.add("Swimming");
        studentActivities.add("Swimming");
        studentActivities.add("Swimming");
        studentActivities.add("Swimming");
        studentActivities.add("Swimming");

        Student barbatiChristian = new Student(studentActivities, new Image("portrait1.jpg"), 200390696, "Christian", "Barbati");

        ArrayList studentActivities2 = new ArrayList();
        studentActivities2.add("Hiking");

        Student barbatiChristian2 = new Student(studentActivities2, new Image("portrait1.jpg"), 204353256, "Test2", "Test3");

        /**
         * Add the instantiated students to the list.
         */
        studentsList.add(barbatiChristian);
        studentsList.add(barbatiChristian2);

        /**
         * Set the listener for the next button
         */
        nextButton.setOnMouseClicked(event -> nextCard());

        /**
         * Set the initial values for the studentCardView
         */
        studentNameLabel.setText("Name: " + studentsList.get(0).getFirstName() + " " + studentsList.get(0).getLastName());
        studentNumLabel.setText("Student Number: " + studentsList.get(0).getStudentNumber());
        imageCircle.setFill(new ImagePattern(studentsList.get(0).getStudentPicture()));

        //Fill the activities
        for(String activity : studentsList.get(currentStudent).getStudentActivities()){
            labelList.add(new Label(activity));
        }
        activityHolder.getChildren().setAll(labelList);
    }
}