import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    private FileUtil() {
    }

    public static String readUsingFiles(String fileName) {
        String result = null;
        try {
            result = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void writeUsingFiles(String data, String file) {
        try {
            Files.write(Paths.get(file), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
