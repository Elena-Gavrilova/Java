import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите коэффициенты a,b и c (a b c) : ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        System.out.printf("Решить квадратное уравнение: %sx^2+%sx+%s=0\n", a, b, c);

        double D = discriminant(a, b, c);
        System.out.println("D=" + D);

        if (isPositive(D)) {
            isRootsEquation(a, b, c);
        } else if (isZero(D)) {
            System.out.println("D=0");
        } else {
            System.out.println("D<0");
        } ;

    }

    private static double discriminant(double a, double b, double c) {
        double d = Math.pow(b, 2) - 4 * a * c;
        return d;
    }

    private static boolean isPositive(double d) {
        return d > 0;
    }

    private static boolean isZero(double d) {
        return d == 0;
    }


    private static void isRootsEquation(double a, double b, double c) {
        double x1 = (-b + Math.sqrt(discriminant(a, b, c))) / 2 * a;
        double x2 = (-b - Math.sqrt(discriminant(a, b, c))) / 2 * a;
        System.out.printf("Корни уравнения: x1=%s; x2=%s\n", x1, x2);
    }


}
