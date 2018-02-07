import java.util.HashMap;
import java.util.Map;

public class TaskDemo {

    public static void main(String[] args) {
        int secondPolynomDegree = 6;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 5);
        map.put(5, 25);

        Polynom firstPolynom = new Polynom(map);
        Polynom SecondPolynom = new Polynom(new HashMap<Integer, Integer>());
        SecondPolynom.fillPolynom(secondPolynomDegree);
        Polynom polynomSum = firstPolynom.getPolynomSum(SecondPolynom);
        printPolynom(firstPolynom);
        printPolynom(SecondPolynom);
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

