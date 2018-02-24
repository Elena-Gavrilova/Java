import java.util.Random;

public class RandomUtils {
    private final static Random random = new Random();
    private static final int NUMBER_TO_GENERATE_THREE = 3;
    private static final int NUMBER_TO_GENERATE_NINE = 9;

    private RandomUtils() {
    }

    public static int randomToFour() {
        return random.nextInt(NUMBER_TO_GENERATE_THREE) + 1;
    }

    public static int randomToNine() {
        return random.nextInt(NUMBER_TO_GENERATE_NINE);
    }

    public static String generateRandomDetail() {
        return String.valueOf(DetailOperationsUtils.DATAILS_OF_THE_ROBOT.get(RandomUtils.randomToNine()));
    }
}



