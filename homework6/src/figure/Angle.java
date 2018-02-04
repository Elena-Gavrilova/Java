package figure;


public class Angle {
    double numerator;
    double denominator;

    public Angle(double numerator, double denominator) {
        if (numerator % Math.PI == 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }

    public double getAngle() {
        return numerator / denominator;
    }

}
