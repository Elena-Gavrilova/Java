
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class TaskDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите степень полинома: ");
        int degree = in.nextInt();

        Polynom polynom1 = new Polynom(new HashMap<Integer, Integer>());
        polynom1.polynom(degree);
        Polynom polynom2 = new Polynom(new HashMap<Integer, Integer>());
        polynom2.polynom(degree);
        Polynom polynomSum = polynom1.getPolynomSum(polynom2);

        polynom1.printPolynom();
        System.out.println();
        polynom2.printPolynom();
        System.out.println();
        polynomSum.printPolynom();

    }


}

