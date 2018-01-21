import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите коэффициенты a,b и c (a b c) : ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        System.out.printf("Решить квадратное уравнение: %sx^2+%sx+%s=0\n", a, b, c);

        double discriminant = discriminant(a, b, c);
        System.out.println("D=" + discriminant);

        if (isPositive(discriminant)) {
            rootsEquation(a, b, c);
        } else if (isZero(discriminant)) {
            rootEquation(a,b);
        };

    }

    private static double discriminant(double a, double b, double c) {
        return Math.pow(b, 2) - 4 * a * c;

    }

    private static boolean isPositive(double d) {
        return d > 0;
    }

    private static boolean isZero(double d) {
        return d == 0;
    }


    private static void rootsEquation(double a, double b, double c) {
        double d=discriminant(a,b,c);
        double x1 = (-b + Math.sqrt(d)) / 2 * a;
        double x2 = (-b - Math.sqrt(d)) / 2 * a;
        System.out.printf("Корни уравнения: x1=%s; x2=%s\n", x1, x2);
    }

    private static void rootEquation(double a, double b) {
        double x1 = -b  / 2 * a;
        System.out.printf("Корень уравнения: x1=%s\n", x1);
    }

}
