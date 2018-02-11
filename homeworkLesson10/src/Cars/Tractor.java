package Cars;

import java.util.Objects;

public class Tractor extends Car {
    private String typeOfTractor;

    public Tractor(String carBrand, String modelCar, int yearOfManufacture, double enginePower, double averageFuelConsumption,
                   String typeOfTractor) {
        super(carBrand, modelCar, yearOfManufacture, enginePower, averageFuelConsumption);
        this.typeOfTractor = typeOfTractor;
    }

    @Override
    public String toString() {
        return "Tractor{" + super.toString() +
                "typeOfTractor='" + typeOfTractor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tractor tractor = (Tractor) o;

        return Objects.equals(typeOfTractor, tractor.typeOfTractor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfTractor);
    }
}
