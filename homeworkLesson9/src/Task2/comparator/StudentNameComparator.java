package Task2.comparator;

import Task2.Student;
import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    private StudentSurnameComparator studentSurnameComparator = new StudentSurnameComparator();

    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.getName().compareTo(o2.getName());
        if (result == 0) {
            result = studentSurnameComparator.compare(o1, o2);
        }
        return result;
    }
}
