import java.util.HashMap;
import java.util.Map;

public class Competitions {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Thread dump = new Thread(new FactoryDump(map));
        Thread servant1 = new Thread(new Servant(map));
        Thread servant2 = new Thread(new Servant(map));

        dump.start();
        servant1.start();
        servant2.start();
    }
}
