import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TaskDemo {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 5);
        map.put(3, 25);
        Polynom firstPolynom = new Polynom(map);

        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(1, 6);
        map2.put(5, 10);
        Polynom secondPolynom = new Polynom(map2);

        Polynom polynomSum = firstPolynom.getPolynomSum(secondPolynom);
        printPolynom(firstPolynom);
        printPolynom(secondPolynom);
        printPolynom(polynomSum);
    }

    private static void printPolynom(Polynom polynom) {
        Map<Integer, Integer> polynomValues = polynom.getValues();
        StringBuilder polynomOutput = new StringBuilder();
        if (polynomValues.size() - 1 != 0) {
            for (int i = polynomValues.size() - 1; i > 1; i--) {
                if (polynomValues.get(i) == 0) {
                    continue;
                }
                polynomOutput.append("+" + polynomValues.get(i) + "x^" + i);
            }
            if (polynomValues.get(1) == 0 && polynomValues.get(0) == 0) {
            } else if (polynomValues.get(1) == 0) {
                polynomOutput.append("+" + polynomValues.get(0));
            } else if (polynomValues.get(0) == 0) {
                polynomOutput.append("+" + polynomValues.get(1) + "x");
            } else {
                polynomOutput.append("+" + polynomValues.get(1) + "x+" + polynomValues.get(0));
            }
        } else {
            polynomOutput.append("+" + polynomValues.get(0));
        }
        System.out.println(polynomOutput.substring(1));
    }
}

