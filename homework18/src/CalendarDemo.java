public class CalendarDemo {

    public static void main(String[] args) {
        String fileName = "calendar";
        String contentsFirstTask = FileUtil.readUsingFiles(fileName);
        String contentsSecondTask = FileUtil.readUsingFiles(fileName);

        FileUtil.writeUsingFiles(String.valueOf(LessonTime.getLessonTime(contentsFirstTask)), "fileFirstTask.txt");
        FileUtil.writeUsingFiles(String.valueOf(LessonStatistic.getLessonStatistic(contentsSecondTask)), "fileSecondTask.txt");
    }
}
