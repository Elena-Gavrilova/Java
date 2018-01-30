import figures.Point;
import figures.Rectangle;

public class Test {

    public static void main(String[] args) {

        Point point1 = new Point(4,3);
        Point point2  = new Point(3,1);
        point1.printDistance(point2);

        Rectangle rectangle = new Rectangle(point1, point2);
        rectangle.printAreaRectangle();
        rectangle.printDiagonal();

    }
}
