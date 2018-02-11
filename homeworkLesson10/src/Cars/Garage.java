package Cars;

import Cars.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Garage {
    private HashMap<Car, Integer> carHashMap;
    private boolean open = false;

    public Garage(HashMap<Car, Integer> carHashMap) {
        this.carHashMap = carHashMap;
    }

    public boolean isGarageOpen() {
        return open;
    }

    public void openGarage() {
        if (isGarageOpen() == false) {
            System.out.println("Открываем гараж!");
            open = true;
        }
    }

    public void closeGarage() {
        if (isGarageOpen()) {
            System.out.println("Закрываем гараж!");
            open = false;
        }
    }

    public Map<Car, Integer> addCar(Car car) {
        Set<Car> collection = carHashMap.keySet();
        for (Car key : collection) {
            if (key.hashCode() == car.hashCode() && key.equals(car)) {
                carHashMap.put(key, carHashMap.get(key) + 1);
            }
        }
        return carHashMap;
    }

    public void park(Car car) {
        if (isGarageOpen()) {
            System.out.println("Машина: " + car.toString() + " паркуется.");
            addCar(car);
            closeGarage();
        } else {
            openGarage();
            System.out.println("Машина: " + car.toString() + " паркуется.");
            addCar(car);
            closeGarage();
        }
    }

    public Map<Car, Integer> removeCar(Car car) {
        Set<Car> collection = carHashMap.keySet();
        for (Car key : collection) {
            if (key.hashCode() == car.hashCode() && key.equals(car) && carHashMap.get(key) != 0) {
                carHashMap.put(key, carHashMap.get(key) - 1);
            }
        }
        return carHashMap;
    }

    public void leave(Car car) {
        if (isGarageOpen()) {
            System.out.println("Машина : " + car.toString() + " выезжаетиз гаража!");
            removeCar(car);
            closeGarage();
        } else {
            openGarage();
            System.out.println("Машина: " + car.toString() + " выезжает из гаража!");
            removeCar(car);
            closeGarage();
        }
    }

    public int numbersCars(Car car) {
        Set<Car> collection = carHashMap.keySet();
        Integer numbers = 0;
        for (Car key : collection) {
            if (key.hashCode() == car.hashCode() && key.equals(car)) {
                numbers = carHashMap.get(key);
            }
        }
        return numbers;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "carHashMap=" + carHashMap.toString() +
                '}';
    }

    public HashMap<Car, Integer> getCarHashMap() {
        return carHashMap;
    }
}
