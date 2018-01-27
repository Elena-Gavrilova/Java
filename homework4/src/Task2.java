

public class Task2 {
    public static void main(String[] args) {
        //1  2 5  4 50 900 3   91  13   29    3999    9
       // I II V IV LC CM III XCI XIII XXIX MMMCMXCIX IX;
        String numberRoman1 = "MMMCMXCIX";//3999


        System.out.println(numberRoman1+" = "+getArabicNumbers(numberRoman1));



    }


    private static int getArabicNumbers(String numberRoman) {

        char[] arrayRomanChar = numberRoman.toCharArray();
        int[] arrayRomanInt = new int[arrayRomanChar.length + 1];

        for (int i = 0; i < arrayRomanChar.length; i++) {
            arrayRomanInt[i] = changeRomanNumbersInArabic(arrayRomanChar[i]);
        }

        int numberArabic = getNumberArabicStart(arrayRomanInt);

        for (int i = 0; i < arrayRomanInt.length - 2; i++) {
            if (arrayRomanInt[i] == arrayRomanInt[i + 1]) {
                numberArabic += arrayRomanInt[i];
            } else if (arrayRomanInt[i] > arrayRomanInt[i + 1] && arrayRomanInt[i + 1] < arrayRomanInt[i + 2]) {
                numberArabic += 0;
            } else if (arrayRomanInt[i] > arrayRomanInt[i + 1]) {
                numberArabic += arrayRomanInt[i + 1];
            } else if (arrayRomanInt[i] < arrayRomanInt[i + 1]) {
                numberArabic += (arrayRomanInt[i + 1] - arrayRomanInt[i]);
            }
        }
        return numberArabic;


    }

    private static int getNumberArabicStart(int[] arrayRomanInt) {
        int numberArabic = 0;

        if (arrayRomanInt[0] < arrayRomanInt[1]) {
            numberArabic = 0;
        } else {
            numberArabic = arrayRomanInt[0];
        }
        return numberArabic;
    }

    private static int changeRomanNumbersInArabic(char numberRoman) {
        char[] arrayRoman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] arrayArabic = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < arrayRoman.length; i++) {
            if (numberRoman == arrayRoman[i]) {
                return arrayArabic[i];
            }
        }
        return 0;
    }

}
