package Task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {
    public static List<String> arrayWords(String text) {
        String pattern = "[\\.?!,]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        String[] testArray = m.replaceAll("").split(" ");
        return Arrays.asList(testArray);
    }

    public static void numbersUniqueWords(List<String> list, Set<String> uniqueList) {
        for (String s : uniqueList) {
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (s.equals(list.get(i))) {
                    count++;
                }
            }
            System.out.println(s + ": " + count);
        }
    }

    public static HashSet<String> uniqueWords(List<String> list) {
        return new HashSet<>(list);
    }
}
