package ASSIGNMENTS.A1_300425781.E3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {
     
    // instance variables
    private String studentID;
    private String firstName;
    private String lastName;
    private double averageGrade;

    // constructor
    public Student(String id, String fn, String ln, double avg) {
        studentID = id;
        firstName = fn;
        lastName = ln;
        averageGrade = avg;
    }

    // getters
    public String getID() { return studentID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getAverageGrade() { return averageGrade; }

    // methods
    public String toString() { return "Student {studentID: \'" + getID() + "\', firstName: \'" + getFirstName() 
                                        + "\', lastName: \'" + getLastName() + "\', averageGrade: " + getAverageGrade() + "}"; }
    
    // natural order
    public int compareTo(Student s) { return this.getID().compareToIgnoreCase(s.getID()); } // lexicographically compare
}