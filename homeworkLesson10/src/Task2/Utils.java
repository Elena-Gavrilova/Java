package Task2;

import Cars.Car;

import java.util.Map;

public final class Utils {
    public static void print(Map<Car, Integer> cars) {
        for (Car car : cars.keySet()) {
            System.out.println(car+": "+cars.get(car));
        }
    }
}
