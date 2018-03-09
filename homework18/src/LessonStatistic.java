import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LessonStatistic {

    private static final String REGEX = "(\\d{2}):(\\d{2})(.+)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final String TIMEOUT_REGEX = "(\\d{2}:\\d{2})(.+)(Перерыв|перерыв)";
    private static final Pattern TIMEOUT_PATTERN = Pattern.compile(TIMEOUT_REGEX);
    private static final String FORMAT = "%s: %s минут %s";
    private static final int MINUTE = 60;
    private static final int PERCENT_ALL = 100;

    private LessonStatistic() {
    }

    public static StringBuffer getLessonStatistic(String content) {
        String contentNew = String.valueOf(replaceAllTimeout(content));
        String[] arrayDays = ContentUtil.hangOutOnDays(contentNew);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < arrayDays.length; i++) {
            buffer.append(statisticForOneDay(arrayDays[i]));
        }

        return buffer;
    }

    private static StringBuffer statisticForOneDay(String contentDay) {
        Matcher matcherFirst = PATTERN.matcher(contentDay);
        Matcher matcherSecond = PATTERN.matcher(contentDay);
        StringBuffer buffer = new StringBuffer();
        Map<String, Integer> mapDay = new HashMap<>();
        while (matcherFirst.find() && matcherSecond.find(matcherFirst.end())) {
            int hourFirst = Integer.parseInt(matcherFirst.group(1));
            int minuteFirst = Integer.parseInt(matcherFirst.group(2));
            int hourSecond = Integer.parseInt(matcherSecond.group(1));
            int minuteSecond = Integer.parseInt(matcherSecond.group(2));
            int minuteResultFirst = translationHoursToMinutes(hourFirst, minuteFirst);
            int minuteResultSecond = translationHoursToMinutes(hourSecond, minuteSecond);
            int resultTime = minuteResultSecond - minuteResultFirst;
            mapDay.merge(matcherFirst.group(3).trim(), resultTime, (v1, v2) -> v1 + v2);
        }
        buffer.append("\nНовый день:\n");
        getStatisticsOfTheDay(buffer, mapDay);
        buffer.append("\nЛекции:\n");
        getStatisticsLecture(buffer, mapDay);

        return buffer;
    }

    private static void getStatisticsOfTheDay(StringBuffer buffer, Map<String, Integer> mapDay) {
        int allTime = getTimeAllDay(mapDay);
        for (String key : mapDay.keySet()) {
            if (key.equals("Упражнения") || key.equals("Перерыв") || key.equals("Решения")) {
                buffer.append(String.format(FORMAT, key, mapDay.get(key), getPercent(mapDay.get(key), allTime)) + "%\n");
            }
        }
        buffer.append(String.format(FORMAT, "Лекции", getTimeOfAllLectures(mapDay), getPercent(getTimeOfAllLectures(mapDay), allTime)) + "%\n");
    }

    private static void getStatisticsLecture(StringBuffer buffer, Map<String, Integer> mapDay) {
        for (String key : mapDay.keySet()) {
            if (!(key.equals("Упражнения") || key.equals("Перерыв") || key.equals("Решения"))) {
                buffer.append(String.format(FORMAT, key, mapDay.get(key), getPercent(mapDay.get(key), getTimeOfAllLectures(mapDay))) + "%\n");
            }
        }
    }

    private static int getTimeOfAllLectures(Map<String, Integer> mapDay) {
        int timeOfAllLectures = 0;
        for (String key : mapDay.keySet()) {
            if (!(key.equals("Упражнения") || key.equals("Перерыв") || key.equals("Решения"))) {
                timeOfAllLectures += mapDay.get(key);
            }
        }

        return timeOfAllLectures;
    }

    private static int getPercent(int time, int allTime) {
        return time * PERCENT_ALL / allTime;
    }

    private static int getTimeAllDay(Map<String, Integer> mapDay) {
        int allTime = 0;
        for (String key : mapDay.keySet()) {
            allTime += mapDay.get(key);
        }

        return allTime;
    }

    private static int translationHoursToMinutes(int hourFirst, int minuteFirst) {
        return hourFirst * MINUTE + minuteFirst;
    }

    private static StringBuffer replaceAllTimeout(String content) {
        Matcher matcherTimeout = TIMEOUT_PATTERN.matcher(content);
        StringBuffer bufferTimeout = new StringBuffer();
        while (matcherTimeout.find()) {
            matcherTimeout.appendReplacement(bufferTimeout, matcherTimeout.group(1) + " Перерыв");
        }
        matcherTimeout.appendTail(bufferTimeout);

        return bufferTimeout;
    }
}
