package figure;

public class Parallelogram extends Figure implements Polygon {
    private double side2;
    private Angle angle;

    public Parallelogram(double side1, double side2, Angle angle, Color color) {
        super(side1, color);
        this.side2 = side2;
        this.angle = angle;
    }

    @Override
    public double area() {
        return side2 * getSide() * Math.sin(angle.getAngle());
    }


    @Override
    public double perimetr() {
        return (getSide() + side2) * 2;
    }

    @Override
    public double height(double side) {
        return area() / side;
    }

    public double diagomal(Angle angle) {
        return Math.sqrt(Math.pow(getSide(), 2) + Math.pow(side2, 2) - 2 * getSide() * side2 * Math.cos(angle.getAngle()));
    }

    public double angle2() {
        return Math.PI - angle.getAngle();
    }

    @Override
    public <T extends Figure> void printDateFigure() {
        super.printDateFigure();
        System.out.println("Периметр полигона: " + perimetr() + "\nВысота полигона к стороне " + side2 + ": " + height(side2) +
                "\nДиагональ полигона из угла " + angle.getAngle() + " : " + diagomal(angle) + "\nВторой угол полигона: " + angle2());
    }

    @Override
    public String toString() {
        return "Parallelogram{" +
                "side1=" + getSide() +
                ", side2=" + side2 +
                ", angle=" + angle.getAngle() +
                ", color=" + getColor() +
                '}';
    }

    public double getSide2() {
        return side2;
    }

    public Angle getAngle() {
        return angle;
    }


}
