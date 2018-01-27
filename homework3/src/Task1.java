import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Количество элементов в массиве : ");
        int numberOfElememtsArray = in.nextInt();

        int[] array = getArray(random, numberOfElememtsArray);

        System.out.print("Введите количество сдвигов : ");
        int numberOfShifts = in.nextInt();

        int[] valuesNew = shiftArrayRight(array, numberOfShifts);
        System.out.println(Arrays.toString(valuesNew));

    }

    private static int[] getArray(Random random, int numberOfElememtsArray) {

        int[] array = new int[numberOfElememtsArray];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50) + 1;
        }

        System.out.println(Arrays.toString(array));
        return array;
    }

    private static int[] shiftArrayRight(int[] array, int numberOfShifts) {
        for (int i = 1; i <= numberOfShifts; i++) {
            array = shiftArrayRightOnce(array);
        }
        return array;
    }

    private static int[] shiftArrayRightOnce(int[] array) {

        int lastElement = array[array.length - 1];

        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = lastElement;

        return array;

    }
}
