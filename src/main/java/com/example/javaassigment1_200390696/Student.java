package com.example.javaassigment1_200390696;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Student {
    /**
     * Two ArrayLists. validActivities holds the different activities that a student object is permitted to hold.
     * validActivities is static so it belongs to all students
     *
     * studentActivities holds the different activities that each individual student enjoys.
     */
    private static ArrayList<String> validActivities = new ArrayList<>();
    private ArrayList<String> studentActivities = new ArrayList<>();

    /**
     * Image object to hold the picture of the student
     */
    private Image studentPicture;

    /**
     * Variables to hold common student characteristics
     */
    private int studentNumber;
    private String firstName;
    private String lastName;

    /**
     * Default constructor
     */
    public Student(ArrayList<String> studentActivities, Image studentPicture, int studentNumber, String firstName, String lastName) {
        setStudentActivities(studentActivities, validActivities);
        setStudentPicture(studentPicture);
        setStudentNumber(studentNumber);
        setFirstName(firstName);
        setLastName(lastName);
    }

    /**
     * Function to add an activity to the validActivities list from other classes
     */

    public static void addValidActivity(String activity){
        validActivities.add(activity);
    }

    /**
     * Getters and Setters
     */

    public static ArrayList<String> getValidActivities() {
        return validActivities;
    }

    public static void setValidActivities(ArrayList<String> validActivities) {
        Student.validActivities = validActivities;
    }

    public ArrayList<String> getStudentActivities() {
        return studentActivities;
    }

    public void setStudentActivities(ArrayList<String> studentActivities, ArrayList<String> validActivities) {
        for(String activity : studentActivities){
            if(validActivities.contains(activity)){
                this.studentActivities.add(activity);
            }
            else{
                throw new IllegalArgumentException();
            }
        }

    }

    public Image getStudentPicture() {
        return studentPicture;
    }

    public void setStudentPicture(Image studentPicture) {
        this.studentPicture = studentPicture;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
