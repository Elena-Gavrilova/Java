package Cars;

import java.util.Objects;

public class Bike extends Car {
    private String typeOfBike;
    private double weightOfBike;

    public Bike(String carBrand, String modelCar, int yearOfManufacture, double enginePower, double averageFuelConsumption,
                String typeOfBike, double weightOfBike) {
        super(carBrand, modelCar, yearOfManufacture, enginePower, averageFuelConsumption);
        this.typeOfBike = typeOfBike;
        this.weightOfBike = weightOfBike;
    }

    @Override
    public String toString() {
        return "Bike{" + super.toString() +
                "typeOfBike='" + typeOfBike + '\'' +
                ", weightOfBike=" + weightOfBike +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;

        return Double.compare(bike.weightOfBike, weightOfBike) == 0 &&
                Objects.equals(typeOfBike, bike.typeOfBike);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfBike, weightOfBike);
    }
}
