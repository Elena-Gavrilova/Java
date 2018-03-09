import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LessonTime {

    private static final String REGEX = "(\\d{2}:\\d{2})(.+)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final String FORMAT= "%s-%s %s";

    private LessonTime() {
    }

    public static StringBuffer getLessonTime(String content) {
        StringBuffer buffer = new StringBuffer();
        String[] arrayDays = ContentUtil.hangOutOnDays(content);
        for (int i = 0; i < arrayDays.length; i++) {
            Matcher matcherFirst = PATTERN.matcher(arrayDays[i]);
            Matcher matcherSecond = PATTERN.matcher(arrayDays[i]);
            while (matcherFirst.find() && matcherSecond.find(matcherFirst.end())) {
                String firstTime = matcherFirst.group(1);
                String secondTime = matcherSecond.group(1);
                String text = matcherFirst.group(2);
                String formattedCalendar = String.format(FORMAT, firstTime, secondTime, text);
                matcherFirst.appendReplacement(buffer, formattedCalendar);
            }
        }

        return buffer;
    }
}
