import java.util.Arrays;



public class Task2 {
    public static void main(String[] args) {

        int[] array = {1, 1, 5, 3, 1, 2, 5, 8, 9, 2};

        System.out.println("Вход:  "+Arrays.toString(array));

        array = replaseEqual(array);
        array = sortZero(array);

        System.out.println("Выход: "+Arrays.toString(array));


    }

    private static int[] replaseEqual(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    array[j] = 0;
                }
            }
        }
        return array;
    }

    private static int[] sortZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
            }
        }
        return array;
    }


}
