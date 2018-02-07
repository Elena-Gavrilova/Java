import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Polynom {

    private Map<Integer, Integer> polynom;

    public Polynom(Map<Integer, Integer> polynom) {
        this.polynom = polynom;
    }

    public Map<Integer, Integer> fillPolynom(int degree) {
        Random random = new Random();
        for (int i = 0; i <= degree; i++) {
            polynom.put(i, random.nextInt(10));
        }

        return polynom;
    }
    private void polynomZero() {
        int key = polynom.get(polynom.size()-1);
        for(int i=0;i<=key;i++){
            if(polynom.get(i)==null){
                polynom.put(i,0); }
        }
    }
    private void fillPolynomWithZeros(Polynom secondPolynom) {
        Map<Integer, Integer> firstPolynomMap = polynom;
        Polynom firstPolynom = new Polynom(firstPolynomMap);
        firstPolynom.polynomZero();
        secondPolynom.polynomZero();
        if (firstPolynom.getValues().size() < secondPolynom.getValues().size()) {
            for (int i = firstPolynom.getValues().size(); i < secondPolynom.getValues().size(); i++) {
                firstPolynom.getValues().put(i, 0);
            }
        } else {
            for (int i = secondPolynom.getValues().size(); i < firstPolynom.getValues().size(); i++) {
                secondPolynom.getValues().put(i, 0);
            }
        }
        polynom=firstPolynom.getValues();
    }

    public Polynom getPolynomSum(Polynom secondPolynom) {
        Map<Integer, Integer> polynomSum = new HashMap<>();
        fillPolynomWithZeros(secondPolynom);
        for (int i = 0; i < polynom.size(); i++) {
            polynomSum.put(i, polynom.get(i) + secondPolynom.getValues().get(i));
        }
        Polynom polymomSum = new Polynom(polynomSum);

        return polymomSum;
    }


    public Map<Integer, Integer> getValues() {
        return polynom;
    }
}


