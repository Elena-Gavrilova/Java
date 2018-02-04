package figure;

public class Circle extends Figure implements Ellipsoid {

    public Circle(double side, Color color) {
        super(side, color);
    }

    @Override
    public double area() {
        return Math.PI * (getSide() * getSide());
    }


    @Override
    public double arcLength() {
        return 2 * Math.PI * getSide();
    }

    @Override
    public double diametr() {
        return getSide() * 2;
    }

    @Override
    public <T extends Figure> void printDateFigure() {
        super.printDateFigure();
        System.out.println("Длина дуги круга: " + arcLength() + "\nДиаметр круга: " + diametr());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + getSide() +
                ", color=" + getColor() +
                '}';
    }
}

