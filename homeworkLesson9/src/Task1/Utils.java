package Task1;

import java.util.List;

public final class Utils {
    private static final String MARK = "****";

    public static List<String> markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, MARK);
                i++;
            }
        }
        return list;
    }
}
