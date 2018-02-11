package Cars;

import java.util.Objects;

public class Bus extends Car {
    private int capacityBus;

    public Bus(String carBrand, String modelCar, int yearOfManufacture, double enginePower, double averageFuelConsumption,
               int capacityBus) {
        super(carBrand, modelCar, yearOfManufacture, enginePower, averageFuelConsumption);
        this.capacityBus = capacityBus;
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() +
                "capacityBus=" + capacityBus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;

        return capacityBus == bus.capacityBus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacityBus);
    }
}
