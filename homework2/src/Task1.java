import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите целое число : ");
        int number = in.nextInt();

        int numberSumRest = getNumberSumRest(number);

        System.out.println("Сумма цифр введенного числа: "+numberSumRest);
    }

    private static int getNumberSumRest(int number) {

        int numberSumRest=0;

        while (number!=0){
            int numberRest=number%10;
            number= number/10;
            numberSumRest+=numberRest;
        }

        return numberSumRest;
    }
}
