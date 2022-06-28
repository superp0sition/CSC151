package Lab15c;

public class Square extends GeometricObject implements Colorable {
    private double side;

    public Square (){
        this(0);
    }

    public Square (double s){
        side = s;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public double getPerimeter() {
        return 4*side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double s){
        side = s;
    }
}
