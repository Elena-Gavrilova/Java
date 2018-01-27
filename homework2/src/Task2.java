import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите целое число : ");
        int number = in.nextInt();

        System.out.print("\nНе рекурсией:\n");
        fibonacci(number);

        System.out.print("\nРекурсией:\n");

        for (int i = 0; fibonacciRecource(i) < number; i++) {
            System.out.print(fibonacciRecource(i) + " ");
        }

    }

    private static void fibonacci(int number) {

        int fib1 = 0;
        int fib2 = 1;

        while (fib1 < number) {
            System.out.print(fib1 + " ");

            int fib0 = fib1;
            fib1 = fib2;
            fib2 = fib1 + fib0;

        }
    }

    //fibonacci - возвращает k-й элемент фибоначи.
    private static int fibonacciRecource(int k) {

        if (k == 0) return 0;
        if (k == 1 || k == 2) return 1;

        return (fibonacciRecource(k - 1) + fibonacciRecource(k - 2));
    }


}
