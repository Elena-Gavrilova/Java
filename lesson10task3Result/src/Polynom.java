import java.util.Collection;
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
    public Map<Integer, Integer> polynomZero() {
        int mapKey = key();
        for(int i=0;i<=mapKey;i++){
            if(polynom.get(i)==null){
                polynom.put(i,0); }
        }
        return  polynom;
    }

    private int key() {
        Collection<Integer> collection = polynom.keySet();
        Integer mapKey=0;
        for (Integer key : collection) {
            if(key>mapKey){
                mapKey=key;
            }
        }
        return mapKey;
    }

    public void fillPolynomWithZeros(Polynom secondPolynom) {
        Map<Integer, Integer> firstPolynomMap = polynom;
        Polynom firstPolynom = new Polynom(firstPolynomMap);
        firstPolynom.polynomZero();
        secondPolynom.polynomZero();
        int firstKey=firstPolynom.key();
        int secondKey=secondPolynom.key();
        if (firstPolynom.key() < secondPolynom.key()) {
            for (int i = firstKey+1; i <=secondKey; i++) {
                firstPolynom.getValues().put(i, 0);
            }
        } else {
            for (int i = secondKey+1; i <= firstKey; i++) {
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


