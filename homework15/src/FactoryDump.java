import java.util.Map;

public class FactoryDump implements Runnable {

    private static final int NUMBER_OF_DATAILS_IN_DUMP_INITIALLY = 20;
    public static final int NUMBER_DAYS = 100;
    private final Map<String, Integer> detailsAtTheDump;

    public FactoryDump(Map<String, Integer> detailsAtTheDump) {
        this.detailsAtTheDump = detailsAtTheDump;
    }

    public Map<String, Integer> generateTwentyDetails() {
        for (int i = 0; i < NUMBER_OF_DATAILS_IN_DUMP_INITIALLY; i++) {
            String detail = RandomUtils.generateRandomDetail();
            DetailOperationsUtils.addingDatail(detailsAtTheDump, detail);
        }

        return detailsAtTheDump;
    }

    public Map<String, Integer> throwAwayDetailsToTheDump() {
        int numberDatailAdding = RandomUtils.randomToFour();
        for (int i = 0; i <= numberDatailAdding; i++) {
            String detail = RandomUtils.generateRandomDetail();
            DetailOperationsUtils.addingDatail(detailsAtTheDump, detail);
        }

        return detailsAtTheDump;
    }

    @Override
    public void run() {
        synchronized (detailsAtTheDump) {
            generateTwentyDetails();
            System.out.println(detailsAtTheDump.toString());
        }
        for (int i = 0; i < NUMBER_DAYS; i++) {
            synchronized (detailsAtTheDump) {
                try {
                    detailsAtTheDump.wait(100);
                    detailsAtTheDump.notifyAll();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throwAwayDetailsToTheDump();
            }
        }
        System.out.println("Осталось на складе" + detailsAtTheDump);
    }

    @Override
    public String toString() {
        return "FactoryDump{" +
                "detailsAtTheDump=" + detailsAtTheDump +
                '}';
    }
}
