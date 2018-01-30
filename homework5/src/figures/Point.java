package figures;

public class Point {
    private double coordinateX;
    private double coordinateY;


    public Point(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public double distance(Point point) {
        return Math.sqrt(Math.pow(point.getCoordinateX() - coordinateX, 2) + Math.pow(point.getCoordinateY() - coordinateY, 2));
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void printDistance(Point point){
        System.out.printf("Расстояние между точками (%s;%s) и (%s;%s): %s \n",coordinateX,coordinateY,
                point.getCoordinateX(),point.getCoordinateY(),distance(point));
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }
}
