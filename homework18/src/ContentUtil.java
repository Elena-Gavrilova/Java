public class ContentUtil {

    private static final String SEPARATOR = "Конец";

    private ContentUtil() {
    }

    public static String[] hangOutOnDays(String content) {
        return content.split(SEPARATOR);
    }
}
