package Cars;

import java.util.Objects;

public class Truck extends Car {
    private int volumeBody;

    public Truck(String carBrand, String modelCar, int yearOfManufacture, double enginePower, double averageFuelConsumption,
                 int volumeBody) {
        super(carBrand, modelCar, yearOfManufacture, enginePower, averageFuelConsumption);
        this.volumeBody=volumeBody;
    }

    @Override
    public String toString() {
        return "Truck{" +super.toString()+
                "volumeBody=" + volumeBody +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;

        return volumeBody == truck.volumeBody;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumeBody);
    }
}
