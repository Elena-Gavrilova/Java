package Task2;

import java.util.Iterator;
import java.util.List;

public final class Utils {

    public static void print(List<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public static Student studentMarkMax(List<Student> list) {
        double markMax = 0;
        Student studentMax = list.get(0);
        for (Iterator<Student> studentIterator = list.iterator(); studentIterator.hasNext(); ) {
            Student student = studentIterator.next();
            double mark = student.getMarkAverage();
            if (markMax < mark) {
                markMax = mark;
                studentMax = student;
            }
        }
        return studentMax;
    }
}
