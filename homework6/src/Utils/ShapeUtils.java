package Utils;


import figure.Figure;
import figure.Parallelogram;
import figure.Triangle;


public final class ShapeUtils {
    ShapeUtils() {

    }

    public static <T extends Parallelogram> boolean testRectangle(T figure) {
        return figure.getSide() != figure.getSide2() &&
                figure.getAngle().getAngle() == Math.PI / 2;
    }

    public static boolean testTriangle(double side1, double side2, double side3) {
        boolean testSide1 = side1 < side2 + side3 &&
                side1 > Math.abs(side2 - side3);
        boolean testSide2 = side2 < side1 + side3 &&
                side2 > Math.abs(side1 - side3);
        boolean testSide3 = side3 < side2 + side1 &&
                side3 > side2 - side1;

        return testSide1 && testSide2 && testSide3;
    }


    public static double theoremPhythagorean(double side1, double side2) {
        return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
    }

}
