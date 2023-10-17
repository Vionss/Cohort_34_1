package ait.shape.model;

public class Square extends Shape{
    public Square(double side) {
        super(side);
    }

    @Override
    public double calcArea() {
        double area = side * 4;
        return area;
    }

    @Override
    public double calcPerimeter() {
        double perimeter = side * side;
        return perimeter;
    }
}
