package Task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Utils {

    private Utils() {
    }

    public static List<String> linePoemList(Path sourcePath) throws IOException {
        List<String> lines = Files.readAllLines(sourcePath);
        return lines.stream()
                .map(it -> it.replaceAll("[\\s\\d\\.,!?:]", ""))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public static List<String> numberOfUniqueLettersList(StringBuffer linePoemList) {
        List<String> result = new ArrayList<>();
        uniqueLetters(linePoemList).stream()
                .peek(it ->
                {
                    int count = 0;
                    for (int j = 0; j < linePoemList.length(); j++) {
                        if ((char) it == linePoemList.charAt(j)) {
                            count++;
                        }
                    }
                    result.add(it + " - " + count);
                })
                .collect(Collectors.toList());

        return result;
    }

    private static Set<Character> uniqueLetters(StringBuffer linePoemList) {
        Set<Character> uniqueLetters = new HashSet();
        for (int i = 0; i < linePoemList.length(); i++) {
            uniqueLetters.add(linePoemList.charAt(i));
        }

        return uniqueLetters;
    }

    public static StringBuffer allTheLettersOfThePoemInString(List<String> linePoemList) {
        StringBuffer numberLetters = new StringBuffer();
        for (int i = 0; i < linePoemList.size(); i++) {
            numberLetters.append(linePoemList.get(i));
        }

        return numberLetters;
    }
}

