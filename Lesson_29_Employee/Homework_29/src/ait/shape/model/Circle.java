package ait.shape.model;

public class Circle extends Shape{
    public Circle(double side) {
        super(side);
    }

    @Override
    public double calcArea() {
        double area = (side * side) * 3.14;
        return area;
    }

    @Override
    public double calcPerimeter() {
        double perimeter = 2 * 3.14 * side;
        return perimeter;
    }
}
