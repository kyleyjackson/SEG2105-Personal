package ASSIGNMENTS.A1_300425781.E3;

import java.util.Comparator;

public class SortStudentsByAverageGrade implements Comparator<Student> {

    // interface method
    public int compare(Student s1, Student s2) {
        double g1 = s1.getAverageGrade() * -1; // multiply by -1 to sort in descending order
        double g2 = s2.getAverageGrade() * -1;

        return Double.compare(g1, g2);
    }
}