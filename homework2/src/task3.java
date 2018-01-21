import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество дней: ");
        int daysAll = in.nextInt();

        int rainfallSum = 0;
        int rainfallMax = 0;

        System.out.print("Введите количество осадков за каждый день: ");
        for (int i = 1; i <= daysAll; i++) {
            int rainfallDay = in.nextInt();
            rainfallMax = isRainfallMax(rainfallDay);
            rainfallSum += rainfallDay;
        }
        int rainfallMean = rainfallSum / daysAll;

        System.out.println("а. Количество дней: " + daysAll);
        System.out.println("b. Сумма осадков за этот период: "+rainfallSum);
        System.out.println("c. Среднее количество осадков за этот период: "+rainfallMean);
        System.out.println("d. Максимальное количество дневных осадков за этот период: "+rainfallMax);

    }

    private static int isRainfallMax(int rainfallDay) {
        int rainfallMax = 0;
        if (rainfallMax <= rainfallDay) {
            rainfallMax = rainfallDay;
        }
        return rainfallMax;
    }
}
