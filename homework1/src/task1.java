import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите дату(день месяц год) : ");
        int day = in.nextInt();
        int month = in.nextInt();
        int year = in.nextInt();

//        System.out.println(isDateTest(day, month, year));
        if (isDateTest(day, month, year)) //isDateTest-тест на проверку существования введенной даты
        {
            nextDay(day, month, year);//isNextDay-находит следующий день
        } else {
            System.out.println("Введенной даты не существует");
        }

    }


    // isNextDay - функция, которая вычисляет следующий день и выводит его на консоль
    private static void nextDay(int day, int month, int year) {
        if (isDayMonth31(month) && day == 31 || isDayMonth31(month) == false && day == 30) {
            if (day == 31 && month == 12) {
                day = 1;
                month = 1;
                year += 1;
            } else {
                day = 1;
                month += 1;
            }
        } else if (day == 28 && month == 2 && isTestLeapYear(year)) {
            day = 29;
            month = 2;
        } else if (day == 28 && month == 2 && isTestLeapYear(year) == false || day == 29 && month == 2 && isTestLeapYear(year)) {
            day = 1;
            month = 3;
        } else {
            day += 1;
        }
        formatOutput(day, month, year);
//        System.out.println(isDateTest(day, month, year));
    }

    private static void formatOutput(int day, int month, int year) {
        System.out.printf("Следующий день: %s.%s.%s\n", day, month, year);
    }

    //isDateTest - тест существования введенной даты
    private static boolean isDateTest(int day, int month, int year) {
        boolean result=false;
       if(year>=1){
            result = isTestDay(day,month,year)&&isTestMonth(month);
        }
       return result;

    }

    //isTestMonth - тест существования месяца
    private static boolean isTestMonth(int month) {
        return (month >= 1 && month <= 12);
    }

    //isDayMonth31 - тест, определяющий месяце с количеством дней равным 31
    //true - если в месяце 31 день
    private static boolean isDayMonth31(int month) {
        return (month <= 7 && month % 2 == 1) || (month >= 8 && month % 2 == 0);

    }

    //isTestDay - тест существования дня.
    //true - если такой день существует (по дню и месяцу)
    private static boolean isTestDay(int day, int month, int year) {
        return (month == 2) ?
                (isTestLeapYear(year) ?
                        (day >= 1 && day <= 29) : (day >= 1 && day <= 28)) :
                (isDayMonth31(month) ?
                        (day >= 1 && day <= 31)  : (day >= 1 && day <= 30));

    }

    //isTestLeapYear - тест на высокосный год
    private static boolean isTestLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));

    }
}
