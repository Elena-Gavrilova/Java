package Task1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static Task1.Utils.markLength4;

public class Task1Demo {
        public static void main(String[] args) {
        String[] array = {"this", "is", "lots", "of", "fun", "for", "every", "Java", "programmer"};
        List<String> list = new LinkedList<>(Arrays.asList(array));
        System.out.println(markLength4(list));
    }
}
