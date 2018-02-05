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

    public Polynom getPolynomSum(Polynom polynom2) {
        HashMap<Integer, Integer> polynom3 = new HashMap<>();
        Polynom polymomSum = new Polynom(polynom3);

        for (int i = 0; i < polynom.size(); i++) {
            polymomSum.getPolynom().put(i, polynom.get(i) + polynom2.getPolynom().get(i));
        }

        return polymomSum;
    }


    public void printPolynom() {
        if (polynom.size() - 1 != 0) {
            for (int i = polynom.size() - 1; i > 1; i--) {
                System.out.print(polynom.get(i) + "x^" + i + "+");
            }
            System.out.print(polynom.get(1) + "x+");
            System.out.print(polynom.get(0));
        } else {
            System.out.print(polynom.get(0));
        }
    }


    public HashMap<Integer, Integer> getPolynom() {
        return polynom;
    }
}


