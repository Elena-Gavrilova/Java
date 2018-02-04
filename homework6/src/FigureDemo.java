import Utils.ShapeUtils;
import figure.*;

public class FigureDemo {

    public static void main(String[] args) {

        Triangle triangle = new Triangle(3, 4, 5, Color.BLUE);
        Rhombus rhombus = new Rhombus(1, new Angle(Math.PI, 3), Color.GREEN);
        Rectangle rectangle = new Rectangle(2, 5, Color.RED);
        Circle circle = new Circle(5, Color.BLUE);
        Parallelogram parallelogram = new Parallelogram(2, 5, new Angle(Math.PI, 6), Color.GREEN);
        Figure line = new Figure(4, Color.RED);

        print(triangle);
        print(rhombus);
        print(rectangle);
        print(circle);
        print(parallelogram);
        print(line);

        System.out.println("Ромб прямоугольник? " + ShapeUtils.testRectangle(rhombus));
        System.out.println("Прямоугольник? " + ShapeUtils.testRectangle(rectangle));
        System.out.println("Неравество треугольника соблюдено? " +
                ShapeUtils.testTriangle(triangle.getSide(), triangle.getSide2(), triangle.getSide3()));

        System.out.println("Сравним площадь прямоугольника и круга: "+rectangle.equalsArea(circle));
        System.out.println("Сравним площадь прямоугольника с самим собой: "+rectangle.equalsArea(rectangle));

    }

    public static <T extends Figure> void print(T figure) {
        figure.printDateFigure();
        figure.getColor().draw();
        System.out.println();

    }


}
