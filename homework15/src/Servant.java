import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Servant implements Runnable {

    public static final int NUMBER_DAYS = 100;
    private Random random = new Random();
    private final Map<String, Integer> detailsAtTheDump;

    public Servant(Map<String, Integer> detailsAtTheDump) {
        this.detailsAtTheDump = detailsAtTheDump;
    }

    public Map<String, Integer> bringTheScientistDetailsFromTheDump(Scientist scientist) {
        List<String> listDetailsAtTheDump = DetailOperationsUtils.makeListOfDetails(detailsAtTheDump);
        int numberOfSelectedDetails = RandomUtils.randomToFour();
        for (int i = 0; i < numberOfSelectedDetails; i++) {
            if (listDetailsAtTheDump.size() != 0) {
                String selectedDetail = selectDetailFromTheList(listDetailsAtTheDump);
                pickUpTheDetailFromTheDump(selectedDetail);
                DetailOperationsUtils.addingDatail(scientist.getDetailsOfTheScientist(), selectedDetail);
                listDetailsAtTheDump = DetailOperationsUtils.makeListOfDetails(detailsAtTheDump);
            }
        }

        return scientist.getDetailsOfTheScientist();
    }

    private String selectDetailFromTheList(List<String> listDetailsAtTheDump) {
        return listDetailsAtTheDump.get(random.nextInt(listDetailsAtTheDump.size()));
    }

    private void pickUpTheDetailFromTheDump(String selectedDetail) {
        detailsAtTheDump.put(selectedDetail, detailsAtTheDump.get(selectedDetail) - 1);
    }

    @Override
    public void run() {
        Map<String, Integer> detailScientist = new HashMap<>();
        Scientist scientist = new Scientist(detailScientist);
        int numberOfRobots = 0;
        for (int i = 0; i < NUMBER_DAYS; i++) {
            synchronized (detailsAtTheDump) {
                bringTheScientistDetailsFromTheDump(scientist);
                try {
                    detailsAtTheDump.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            numberOfRobots = scientist.makeRobot(numberOfRobots);
        }
        System.out.println("Количество роботов: " + numberOfRobots);
    }
}
