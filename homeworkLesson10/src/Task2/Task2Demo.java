package Task2;

import Cars.*;

import java.util.HashMap;
import java.util.Map;

import static Task2.Utils.print;

public class Task2Demo {
    public static void main(String[] args) {
        Car bike = new Bike("BMW", "BMW K 1200 RS", 2000,
                130,5.8,"спорт-турист",285 );
        Car bus = new Bus("МАЗ","МАЗ 206",2006,
                178,20,72);
        Car tractor = new Tractor("Беларус","МТЗ 3022",2008,
                303, 8.7, "колесный трактор");
        Car truck = new Truck("МАЗ","МАЗ 63",2006,
                330, 14.9,45);
        Map<Car,Integer> cars = new HashMap<>();
        cars.put(bike, 3);
        cars.put(bus,2);
        cars.put(tractor,0);
        cars.put(truck,6);

        print(cars);
        System.out.println();
        Garage garage = new Garage((HashMap<Car, Integer>) cars);
        garage.park(bike);
        System.out.println();
        garage.leave(truck);
        System.out.println();
        print(cars);
    }
}
