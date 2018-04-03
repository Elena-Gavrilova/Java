package library.util;

import library.dao.BookDao;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageUtil {

    private static final int COUNT_BOOK = 10;
    private static final int COUNT_STRING = 50;

    public static int countPageAll(int countBook) {
        return countBook / COUNT_BOOK + 1;
    }

    public static int countPageString(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(fileName));
        String line = null;
        int count=0;
        while( ( line = reader.readLine() ) != null ) {
            count++;
        }
        return (count/COUNT_STRING )+1;
    }

}
