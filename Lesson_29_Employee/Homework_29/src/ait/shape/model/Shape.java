package ait.shape.model;

public abstract class Shape {
    /*
 Создайте абстрактный класс Shape с полем side типа double и абстрактными методами calcArea и calcPerimeter.
Создайте классы Circle, Triangle, Square, которые наследуют классу Shape и реализуют абстрактные методы.
Напишите класс FigureAppl с методом main. В методе создайте массив фигур. Добавьте в массив два круга, один треугольник и один квадрат.
 Рассчитайте общую площадь и общий периметр всех фигур из массива фигур.
Вычислите общую площадь кругов. (*)
     */
    protected double side;

    public abstract double calcArea();
    public abstract double calcPerimeter();

    public Shape(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shape{");
        sb.append("side=").append(side);
        sb.append('}');
        return sb.toString();
    }
}
