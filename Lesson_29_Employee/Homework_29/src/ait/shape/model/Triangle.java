package ait.shape.model;

public class Triangle extends Shape{
    public Triangle(double side) {
        super(side);
    }

    @Override
    public double calcArea() {
        double area = (1.732 / 4) * (side * side);
        return area;
    }

    @Override
    public double calcPerimeter() {
        double perimeter = side * 3;
        return perimeter;
    }
}
