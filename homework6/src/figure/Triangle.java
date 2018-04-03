package figure;

import Utils.ShapeUtils;

public class Triangle extends Figure implements Polygon {
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3, Color color) {
        super(side1, color);
        if (ShapeUtils.testTriangle(side1, side2, side3)) {
            this.side2 = side2;
            this.side3 = side3;
        }

    }

    @Override
    public double area() {
        double p = perimetr() / 2;

        return Math.sqrt(p * (p - getSide()) * (p - side2) * (p - side3));
    }

    @Override
    public double perimetr() {
        return getSide() + side2 + side3;
    }

    @Override
    public double height(double side) {
        return area() / (side * 0.5);
    }

    @Override
    public <T extends Figure> void printDateFigure() {
        super.printDateFigure();
        System.out.println("Периметр треугольника: " + perimetr() + "\nВысота треугольника к стороне " + getSide() +
                ": " + height(getSide()));
    }

    @Override
    public String toString() {
        return "Triangle{" + "" +
                "side1=" + getSide() +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", color=" + getColor() +
                '}';
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }


}
