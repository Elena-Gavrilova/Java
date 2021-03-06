import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество дней: ");
        int daysAll = in.nextInt();

        int rainfallMax = 0;
        int rainfallSum = 0;


        System.out.print("Введите количество осадков за каждый день: ");

        for (int i = 1; i <= daysAll; i++) {

            int rainfallDay = in.nextInt();

            rainfallMax = funcRainfallMax(rainfallDay, rainfallMax);
            rainfallSum += rainfallDay;
        }

        int rainfallMean = rainfallSum / daysAll;

        System.out.println("\n");
        System.out.println("а. Количество дней: " + daysAll);
        System.out.println("b. Сумма осадков за этот период: "+rainfallSum);
        System.out.println("c. Среднее количество осадков за этот период: "+rainfallMean);
        System.out.println("d. Максимальное количество дневных осадков за этот период: "+rainfallMax);

    }

    private static int funcRainfallMax(int rainfallDay, int rainfallMax) {

        if (rainfallMax < rainfallDay) {
            rainfallMax = rainfallDay;
        }

        return rainfallMax;
    }
}
