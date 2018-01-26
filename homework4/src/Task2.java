import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        //1 5 4 50 900 3 91 13 29 3999 9
        String value = "I V IV LC CM III XCI XIII XXIX MMMCMXCIX IX";
        //language=RegExp
        getNumbersRoman(value);


    }


    private static void getNumbersRoman(String value) {
        String regex = "[IVXLCDM](\\w*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            String result = matcher.group();
            getArabicNumbers(result);
        }
    }

    private static void getArabicNumbers(String value) {
        if (value.length() == 1) {
            value = changeRomanNumbersInArabic(value);
            System.out.println(value);

        } else {
            char[] arrayRomanChar = value.toCharArray();
            int[] arrayRomanInt = new int[arrayRomanChar.length + 1];
            for (int i = 0; i < arrayRomanChar.length; i++) {
                arrayRomanInt[i] = changeRomanNumbersInArabic(arrayRomanChar[i]);
            }

            int numberArabic = 0;
            if (arrayRomanInt[0] < arrayRomanInt[1]) {
                numberArabic = 0;
            } else {
                numberArabic = arrayRomanInt[0];
            }

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
            System.out.println(numberArabic);


        }


    }

    private static String changeRomanNumbersInArabic(String value) {
        return value.replace("I", "1")
                .replace("V", "5")
                .replace("X", "10")
                .replace("L", "50")
                .replace("C", "100")
                .replace("D", "500")
                .replace("M", "1000");
    }

    private static int changeRomanNumbersInArabic(char value) {
        int result = value == 'I' ? 1 :
                value == 'V' ? 5 :
                        value == 'X' ? 10 :
                                value == 'L' ? 50 :
                                        value == 'C' ? 100 :
                                                value == 'D' ? 500 :
                                                        value == 'M' ? 1000 : 0;
        return result;

    }

}
