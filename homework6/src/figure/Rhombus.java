package figure;

public class Rhombus extends Parallelogram {

    public Rhombus(double side, Angle angle, Color color) {
        super(side, side, angle, color);
    }

    @Override
    public double area() {
        return getSide() * getSide() * Math.sin(getAngle().getAngle());
    }

    @Override
    public double perimetr() {
        return getSide() * 4;
    }
}
