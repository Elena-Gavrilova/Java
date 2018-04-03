package figure;

public class Figure implements GeometricalFigure {
    private double side;
    private Color color;

    public Figure(double side, Color color) {
        this.color = color;
        this.side = side;
    }

    @Override
    public double area() {
        return side;
    }

    public <T extends Figure> boolean equalsArea(T figure) {
        return area() == figure.area();
    }

    public <T extends Figure> void printDateFigure() {
        System.out.println("Данные о фигуре: " + toString() + "\nПлощадь фигуры: " + area());
    }

    @Override
    public String toString() {
        return "Figure{" +
                "side=" + side +
                ", color=" + color +
                '}';
    }

    public Color getColor() {
        return color;
    }

    public double getSide() {
        return side;
    }

}
