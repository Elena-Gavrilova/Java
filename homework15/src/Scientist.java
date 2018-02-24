import java.util.List;
import java.util.Map;

public class Scientist {
    private Map<String, Integer> detailsOfTheScientist;

    public Scientist(Map detailsOfTheScientist) {
        this.detailsOfTheScientist = detailsOfTheScientist;
    }

    public Map<String, Integer> getDetailsOfTheScientist() {
        return detailsOfTheScientist;
    }

    public int makeRobot(int numberOfRobots) {
        List<String> listDetailsScientist = DetailOperationsUtils.makeListOfDetails(detailsOfTheScientist);
        if (listDetailsScientist.size() == DetailOperationsUtils.NUMBER_DETAILS) {
            takeTheDetailsToAssembleTheRobot(listDetailsScientist);
            numberOfRobots++;
        }

        return numberOfRobots;
    }

    private void takeTheDetailsToAssembleTheRobot(List<String> listDetailsScientist) {
        for (int j = 0; j < DetailOperationsUtils.NUMBER_DETAILS; j++) {
            Integer numberDetails = detailsOfTheScientist.get(listDetailsScientist.get(j)) - 1;
            detailsOfTheScientist.put(listDetailsScientist.get(j), numberDetails);
        }
    }

    @Override
    public String toString() {
        return "Scientist{" +
                "detailsOfTheScientist=" + detailsOfTheScientist +
                '}';
    }
}
