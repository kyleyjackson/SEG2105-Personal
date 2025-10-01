package ASSIGNMENTS.A1_300425781.E3;

import java.util.Comparator;

public class SortStudentsByLastName implements Comparator<Student> {

    // interface method
    public int compare(Student s1, Student s2) { return s1.getLastName().compareToIgnoreCase(s2.getLastName()); } // lexicographically compare
}