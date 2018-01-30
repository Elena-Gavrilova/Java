package figures;

public class Rectangle {
    private Point cornerLeft;
    private Point cornerRight;

    public Rectangle(Point cornerLeft, Point cornerRight) {
        this.cornerLeft = cornerLeft;
        this.cornerRight = cornerRight;
    }

    public double areaRectangle() {
        double area = -1;
        if (testRectangle()) {
            double[] side =sideOfRectangle();
            area=side[0] * side[1];
           }

        return area;
    }

    public double diagonal() {
        return testRectangle()?cornerLeft.distance(cornerRight):-1;
    }


    public double[] sideOfRectangle(){
        double sideOfRectangle1 = cornerRight.getCoordinateX() - cornerLeft.getCoordinateX();
        double sideOfRectangle2 = cornerLeft.getCoordinateY() - cornerRight.getCoordinateY();
        double [] side ={sideOfRectangle1,sideOfRectangle2};

        return  side;
    }

    private boolean testRectangle() {
        return cornerLeft.getCoordinateY() > cornerRight.getCoordinateY() && cornerLeft.getCoordinateX() < cornerRight.getCoordinateX();
    }

    public void printAreaRectangle(){
        if(areaRectangle()!=-1){
            System.out.println("Площадь прямоугольника: "+areaRectangle());
        } else {
            System.out.println("Проверьте введенные координаты углов прямоугольника!");
        }
    }

    public void printDiagonal(){
        if(diagonal()!=-1){
            System.out.println("Диагональ прямоугольника: "+diagonal());
        } else {
            System.out.println("Проверьте введенные координаты углов прямоугольника!");
        }
    }
}
