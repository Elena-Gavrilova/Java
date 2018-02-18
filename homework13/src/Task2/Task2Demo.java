package Task2;


import javax.print.attribute.standard.Fidelity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Task2Demo {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src", "Task2", "number");

        List<Integer> numbers = new ArrayList<>();
        fillList(numbers);
        numbers.sort(Integer::compareTo);
        List<String> resultNumbers = numbers.stream()
                .map(it -> it.toString())
                .collect(Collectors.toList());
        Files.write(path, resultNumbers);
    }

    private static void fillList(List<Integer> numbers) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            numbers.add(random.nextInt(100));
            i++;
        }
    }
}
