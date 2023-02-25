package com.example.javaassigment1_200390696;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
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

    private int currentStudent = 0;

    /**
     * Function to be called when the next button is pressed. Should move to next student item in studentList
     * and update the view accordingly.
     */
    private void nextCard(){
        currentStudent++;

        if(currentStudent >= studentsList.size()){
            currentStudent = 0;
        }

        studentNameLabel.setText("Name: " + studentsList.get(currentStudent).getFirstName() + " " + studentsList.get(currentStudent).getLastName());
        studentNumLabel.setText("Student Number: " + studentsList.get(currentStudent).getStudentNumber());
        imageCircle.setFill(new ImagePattern(studentsList.get(currentStudent).getStudentPicture()));


        }

        private ArrayList<Student> studentsList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /**
         * Initialize a student (testing view, come back to this later to clean up implementation
         */
        Image studentPicture1 = new Image("C:\\Users\\Chris\\IdeaProjects\\200390696JavaAssignment1\\src\\main\\resources\\com\\example\\javaassigment1_200390696\\portrait1.jpg");
        ArrayList studentActivities = new ArrayList();
        studentActivities.add("Hiking");
        Student barbatiChristian = new Student(studentActivities, studentPicture1, 200390696, "Christian", "Barbati");

        Image studentPicture2 = new Image("C:\\Users\\Chris\\IdeaProjects\\200390696JavaAssignment1\\src\\main\\resources\\com\\example\\javaassigment1_200390696\\portrait1.jpg");
        ArrayList studentActivities2 = new ArrayList();
        studentActivities.add("Hiking");
        Student barbatiChristian2 = new Student(studentActivities, studentPicture2, 204353256, "Test2", "Test3");

        studentsList.add(barbatiChristian);

        studentsList.add(barbatiChristian2);
        nextButton.setOnMouseClicked(event -> nextCard());

        studentNameLabel.setText("Name: " + studentsList.get(0).getFirstName() + " " + studentsList.get(0).getLastName());
        studentNumLabel.setText("Student Number: " + studentsList.get(0).getStudentNumber());
        imageCircle.setFill(new ImagePattern(studentsList.get(0).getStudentPicture()));
    }
}