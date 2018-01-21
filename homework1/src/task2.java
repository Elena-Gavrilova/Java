import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите размеры первого дома (a b) : ");
        int a = in.nextInt();
        int b = in.nextInt();

        System.out.print("Введите размеры второго дома (c d) : ");
        int c = in.nextInt();
        int d = in.nextInt();

        int e = 10;
        int f = 10;
        System.out.printf("Размер участка: %sx%s\n\n", e, f);
        int areaPlace = isArea(e, f);
        int areaHome1 = isArea(a, b);
        int areaHome2 = isArea(c, d);

        if (isCompare(areaPlace, areaHome1) && isCompare(areaPlace, areaHome2)) {
            if (a <= e && b <= f) {
                int areaRemaining = areaPlace - areaHome1;
                if (isCompare(areaRemaining, areaHome2)) {
                    int eRemaining = e - a;
                    int fRemeining = f - b;
                    if (c < eRemaining && d < f || d < fRemeining && c < e) {
                        System.out.println("Дома поместятся");
                    } else {
                        System.out.println("Второй дом не поместился");
                    }

                } else {
                    System.out.println("Поместиться только один дом (первый)");
                }

            } else {
                System.out.println("Первый дом не поместился");
            }
        } else {
            System.out.println("Не поместилось оба дома");
        }

    }

    private static int isArea(int a, int b) {
        int s = a * b;
        return s;
    }

    private static boolean isCompare(int value1, int value2) {
        return value1 >= value2;
    }
}
