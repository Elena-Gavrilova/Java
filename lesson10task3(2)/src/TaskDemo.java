import java.util.HashMap;

public class TaskDemo {

    public static void main(String[] args) {
        int degree1 = 4;
        int degree2 = 6;

        Polynom polynom1 = new Polynom(new HashMap<Integer, Integer>());
        polynom1.polynom(degree1);
        Polynom polynom2 = new Polynom(new HashMap<Integer, Integer>());
        polynom2.polynom(degree2);
        Polynom polynomSum = polynom1.getPolynomSum(polynom2);

        printPolynom(polynom1);
        printPolynom(polynom2);
        printPolynom(polynomSum);

    }

    static void printPolynom(Polynom polynom) {
        HashMap<Integer, Integer> polynomValues = polynom.getPolynom();
        String str = "";
        if (polynomValues.size() - 1 != 0) {
            for (int i = polynomValues.size() - 1; i > 1; i--) {
                if (polynomValues.get(i) == 0) {
                    continue;
                }
                str += "+" + polynomValues.get(i) + "x^" + i;
            }
            if (polynomValues.get(1) == 0 && polynomValues.get(0) == 0) {
                str += "";
            } else if (polynomValues.get(1) == 0) {
                str += "+" + polynomValues.get(0);
            } else if (polynomValues.get(0) == 0) {
                str += "+" + polynomValues.get(1) + "x";
            } else {
                str += "+" + polynomValues.get(1) + "x+" + polynomValues.get(0);
            }
        } else {
            str += "+" + polynomValues.get(0);
        }
        System.out.println(str.substring(1));
    }
}

