public class Task1 {

        public static void main(String[] args) {
            StringBuilder value = new StringBuilder("abcba");

            System.out.printf("%s полиндром? \n%s",value,isPalindrom(value));

        }

    private static boolean isPalindrom(StringBuilder value) {
        return value.toString().equals(value.reverse().toString());
    }

}
