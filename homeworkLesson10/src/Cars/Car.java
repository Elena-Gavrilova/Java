package Cars;

import java.util.Objects;

public class Car {
    private String carBrand;
    private String modelCar;
    private int yearOfManufacture;
    private double enginePower;
    private double averageFuelConsumption;

    public Car(String carBrand, String modelCar, int yearOfManufacture, double enginePower, double averageFuelConsumption) {
        this.carBrand = carBrand;
        this.modelCar = modelCar;
        this.yearOfManufacture = yearOfManufacture;
        this.enginePower = enginePower;
        this.averageFuelConsumption = averageFuelConsumption;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", modelCar='" + modelCar + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", enginePower=" + enginePower +
                ", averageFuelConsumption=" + averageFuelConsumption +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;

        return yearOfManufacture == car.yearOfManufacture &&
                Double.compare(car.enginePower, enginePower) == 0 &&
                Double.compare(car.averageFuelConsumption, averageFuelConsumption) == 0 &&
                Objects.equals(carBrand, car.carBrand) &&
                Objects.equals(modelCar, car.modelCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carBrand, modelCar, yearOfManufacture, enginePower, averageFuelConsumption);
    }

    public String getModelCar() {
        return modelCar;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public String getCarBrand() {
        return carBrand;
    }
}
