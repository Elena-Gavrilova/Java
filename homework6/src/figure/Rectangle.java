package figure;

import Utils.ShapeUtils;

public class Rectangle extends Parallelogram {

    public Rectangle(double side1, double side2, Color color) {
        super(side1, side2, new Angle(Math.PI, 2), color);
    }

    @Override
    public double area() {
        return getSide() * getSide2();
    }

    @Override
    public double height(double side) {
        return side;
    }


    public double diagomal() {
        return ShapeUtils.theoremPhythagorean(getSide(), getSide2());
    }

    @Override
    public <T extends Figure> void printDateFigure() {
        super.printDateFigure();
        System.out.println("Периметр прямоугольника: " + perimetr() + "\nВысота прямоугольника к стороне " + getSide() + ": " + height(getSide()) +
                "\nДиагональ прямугольника: " + diagomal());
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "side1 =" + getSide() +
                ", side2=" + getSide2() +
                ", color=" + getColor() +
                '}';
    }
}
