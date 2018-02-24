import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DetailOperationsUtils {

    public static final int NUMBER_DETAILS = 9;
    public static final List DATAILS_OF_THE_ROBOT = Arrays.asList(DetailsOfTheRobot.values());

    private DetailOperationsUtils() {
    }

    public static void addingDatail(Map<String, Integer> objectOfAdding, String detail) {
        if (!objectOfAdding.containsKey(detail)) {
            objectOfAdding.put(detail, 1);
        } else {
            objectOfAdding.put(detail, objectOfAdding.get(detail) + 1);
        }
    }

    public static List<String> makeListOfDetails(Map<String, Integer> mapDetails) {
        List<String> listDetails = new ArrayList();
        for (int i = 0; i < NUMBER_DETAILS; i++) {
            String detail = String.valueOf(DATAILS_OF_THE_ROBOT.get(i));
            if (mapDetails.containsKey(detail) && mapDetails.get(detail) != 0) {
                listDetails.add(detail);
            }
        }

        return listDetails;
    }
}
