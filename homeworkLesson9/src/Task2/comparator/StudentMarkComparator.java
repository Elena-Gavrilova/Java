package Task2.comparator;

import Task2.Student;
import java.util.Comparator;

public class StudentMarkComparator implements Comparator<Student> {
    private Student student;

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getMarkAverage(), o2.getMarkAverage());
    }
}
