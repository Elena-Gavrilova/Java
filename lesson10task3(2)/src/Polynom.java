import java.util.HashMap;
import java.util.Random;

public class Polynom {

    private HashMap<Integer, Integer> polynom;

    public Polynom(HashMap<Integer, Integer> polynom) {
        this.polynom = polynom;
    }

    public HashMap<Integer, Integer> polynom(int degree) {
        Random random = new Random();
        for (int i = 0; i <= degree; i++) {
            polynom.put(i, random.nextInt(10));
        }

        return polynom;
    }

    private void fillPolynomWithZeros(Polynom polynom2) {
        if (polynom.size() < polynom2.getPolynom().size()) {
            for (int i = polynom.size(); i < polynom2.getPolynom().size(); i++) {
                polynom.put(i, 0);
            }
        } else {
            for (int i = polynom2.getPolynom().size(); i < polynom.size(); i++) {
                polynom2.getPolynom().put(i, 0);
            }
        }
    }

    public Polynom getPolynomSum(Polynom polynom2) {
        HashMap<Integer, Integer> polynom3 = new HashMap<>();
        fillPolynomWithZeros(polynom2);
        for (int i = 0; i < polynom.size(); i++) {
            polynom3.put(i, polynom.get(i) + polynom2.getPolynom().get(i));
        }
        Polynom polymomSum = new Polynom(polynom3);

        return polymomSum;
    }

    public HashMap<Integer, Integer> getPolynom() {
        return polynom;
    }
}


