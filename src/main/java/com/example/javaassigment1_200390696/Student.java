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
     * Instance variables to hold common student characteristics
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

    public ArrayList<String> getStudentActivities() {
        return studentActivities;
    }

    /**
     * Validates the passed ArrayList of favourite activities against the static ArrayList of valid activities
     * @param studentActivities
     * @param validActivities
     */
    public void setStudentActivities(ArrayList<String> studentActivities, ArrayList<String> validActivities) {
        /**
         * Iterates over every activity in the ArrayList passed, and adds them to the instance studentActivities
         * ArrayList if they pass validation. If one does not pass validation, throws an exception.
         *
         * Also checks to make sure that instance studentActivities does not already contain the activity, to prevent
         * duplicate entries.
         */
        for(String activity : studentActivities){
            if(validActivities.contains(activity) && !this.studentActivities.contains(activity)){
                this.studentActivities.add(activity);
            }
            else{
                throw new IllegalArgumentException("Activities must be in the list of valid activities, and must not " +
                        "contain duplicates.");
            }
        }

    }

    public Image getStudentPicture() {
        return studentPicture;
    }

    /**
     * Set the instance student picture to the Image object passed at construction
     * @param studentPicture
     */
    public void setStudentPicture(Image studentPicture) {
        this.studentPicture = studentPicture;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * Valid student numbers begin at 10000000, end at 999999999
     * @param studentNumber
     */
    public void setStudentNumber(int studentNumber) {
        if(studentNumber <= 10000000){
            throw new IllegalArgumentException(studentNumber + " was received, but student numbers must be greater than 10000000.");
        }else if(studentNumber > 999999999){
            throw new IllegalArgumentException(studentNumber + "was received, but student numbers must be less than 999999999");
        }else {
            this.studentNumber = studentNumber;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * First name must be greater than 2 characters (not including white-space). Must start with a capital letter.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        /**
         * Remove leading and trailing spaces, and capitalize first character
         * Then validate; if firstName is shorter than 2 characters (not counting white-space), throw an exception.
         */
        firstName = firstName.trim();
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);

        if(firstName.length() < 2){
            throw new IllegalArgumentException(firstName + " was received, but names must contain at least two non-white-space characters.");
        }else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Last name must be greater than 2 characters (not including white-space). Must start with a capital letter.
     * @param lastName
     */
    public void setLastName(String lastName) {
        /**
         * Remove leading and trailing spaces, and capitalize first character
         * Then validate; if lastName is shorter than 2 characters (not counting white-space), throw an exception.
         */
        lastName = lastName.trim();
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);

        if(lastName.length() < 2){
            throw new IllegalArgumentException(lastName + " was received, but names must contain at least two non-white-space characters.");
        }else {
            this.lastName = lastName;
        }
    }
}
