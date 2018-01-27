import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите длинну строк двумерного массива : ");
        int numberOfElememtsArray1 = in.nextInt();
        int numberOfElememtsArray2 = in.nextInt();

        int[][] array2D = getArray2D(random, numberOfElememtsArray1, numberOfElememtsArray2);
        int[] array1D = getArray1D(array2D);

        System.out.println(Arrays.toString(array2D[0]) + Arrays.toString(array2D[1]));
        System.out.println(Arrays.toString(array1D));


    }

    private static int[] getArray1D(int[][] array2D) {

        int lengthArray2D1 = array2D[0].length;
        int lengthArray2D2 = array2D[1].length;

        int[] array1D = new int[lengthArray2D1 + lengthArray2D2];

        for (int i = 0; i < array1D.length; i++) {
            if (i >= 0 && i < lengthArray2D1) {
                array1D[i] = array2D[0][i];
            } else {
                System.arraycopy(array2D[1], 0, array1D, lengthArray2D1, lengthArray2D2);
            }
        }

        return array1D;
    }

    private static int[][] getArray2D(Random random, int numberOfElememtsArray1, int numberOfElememtsArray2) {

        int[] array1 = new int[numberOfElememtsArray1];
        int[] array2 = new int[numberOfElememtsArray2];

        for (int i = 0; i < numberOfElememtsArray1; i++) {
            array1[i] = random.nextInt(50) + 1;
        }

        for (int i = 0; i < numberOfElememtsArray2; i++) {
            array2[i] = random.nextInt(50) + 1;
        }

        int[][] array2D = {array1, array2};

        return array2D;
    }


}
