import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Task3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Количество элементов в массивах : ");
        int numberOfElememtsArray1 = in.nextInt();
        int numberOfElememtsArray2 = in.nextInt();

        int[] array1 = getArray(random, numberOfElememtsArray1);
        int[] array2 = getArray(random, numberOfElememtsArray2);

        if (array2.length > array1.length) {
            int[] values3 = array1;
            array1 = array2;
            array2 = values3;
        }

        int[] arrays3 = uniteArrays(array1, array2);

        System.out.println("Объединение массивов через один: " + Arrays.toString(arrays3));


    }

    private static int[] uniteArrays(int[] array1, int[] array2) {

        int[] array3 = new int[array1.length + array2.length];

        for (int i = 0, j = 0, k = 0; i < array3.length; i++) {

            while (j < array2.length) {
                if (i % 2 == 1) {
                    array3[i] = array2[j];
                    j++;
                } else {
                    while (k < array1.length) {
                        array3[i] = array1[k];
                        break;
                    }
                    k++;
                }
                break;
            }

        }
        for (int i = array2.length * 2; i < array3.length; i++) {

            array3[i] = array1[i - array2.length];
        }

        return array3;
    }

    private static int[] getArray(Random random, int numberOfElememtsArray) {

        int[] array = new int[numberOfElememtsArray];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50) + 1;
        }

        System.out.println(Arrays.toString(array));
        return array;
    }


}
