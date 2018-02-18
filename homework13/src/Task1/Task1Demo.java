package Task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Task1Demo {

    public static void main(String[] args) throws IOException {
        Path sourcePath = Paths.get("src", "Task1", "poem");
        Path destPath = Paths.get("src", "Task1", "new_poem");

        List<String> result = Utils.numberOfUniqueLettersList(Utils.allTheLettersOfThePoemInString(Utils.linePoemList(sourcePath)));
        Collections.sort(result);
        Files.write(destPath, result);
    }
}
