package library.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UtilFile {

    public final static String FILE_PATH = "E://book";
    private static final int COUNT_STRING = 50;
    private static final String OPEN_TAG = "<p style=\"text-indent:1.5em\">";
    private static final String CLOSE_TAG = "</p>";

    public static void writeUsingFiles(String data,String file) {
        try {
            Files.write(Paths.get(FILE_PATH +file), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readUsingBufferedReaderText(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
        }
        return stringBuilder.toString();
    }

    public static String findAllPageWhole(String fileName, int numberPage) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        StringBuffer stringBuffer = new StringBuffer();
        List<String> text = new ArrayList();
        while ((line = reader.readLine()) != null) {
            text.add(line);
        }
        int start = numberPage * COUNT_STRING  - COUNT_STRING ;
        while (start < numberPage * COUNT_STRING  && start < text.size()) {
            stringBuffer.append(OPEN_TAG);
            stringBuffer.append(text.get(start));
            stringBuffer.append(CLOSE_TAG);
            start++;
        }

        return stringBuffer.toString();
    }


    public static String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(fileName));
        String line = null;
        StringBuffer stringBuffert = new StringBuffer();
        while( ( line = reader.readLine() ) != null ) {
            stringBuffert.append( OPEN_TAG);
            stringBuffert.append( line );
            stringBuffert.append( CLOSE_TAG );
        }
        stringBuffert.deleteCharAt(stringBuffert.length()-1);

        return stringBuffert.toString();
    }
}
