package Task2;

import Task2.comparator.StudentAgeComparator;
import Task2.comparator.StudentNameComparator;

import java.util.ArrayList;
import java.util.List;

import static Task2.Utils.print;
import static Task2.Utils.studentMarkMax;

public class Task2Demo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Виктория", "Васильева", 20, 9));
        list.add(new Student("Елена", "Гаврилова", 20, 9));
        list.add(new Student("Ангелина", "Исакович", 19, 8));
        list.add(new Student("Ангелина", "Крутая", 20, 7));

        Student student = studentMarkMax(list);
        System.out.println(student+"\n");
        list.sort(new StudentNameComparator());
        print(list);
        System.out.println();
        list.sort(new StudentAgeComparator());
        print(list);
    }
}
