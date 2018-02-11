package Task2.comparator;

import Task2.Student;
import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {
    private StudentMarkComparator studentMarkComparator = new StudentMarkComparator();

    @Override
    public int compare(Student o1, Student o2) {
        int result = Integer.compare(o1.getAge(), o2.getAge());
        if (result == 0) {
            result = studentMarkComparator.compare(o1, o2);
        }
        return result;
    }
}
