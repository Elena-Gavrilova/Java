package Task1;

import java.util.List;
import java.util.Set;

import static Task1.Utils.arrayWords;
import static Task1.Utils.numbersUniqueWords;
import static Task1.Utils.uniqueWords;

public class Task1Demo {
    public static void main(String[] args) {
        String text = "Christmas Day is one of the most favorite American holidays It is celebrated on December twenty five. " +
                "Christmas is a Christian holiday marking the birth of the Christ Child.";
        List<String> list = arrayWords(text);
        Set<String> uniqueList = uniqueWords(list);
        System.out.println(uniqueList);
        numbersUniqueWords(list, uniqueList);
    }
}
