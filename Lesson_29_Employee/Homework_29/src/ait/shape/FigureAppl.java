package ait.shape;

import ait.shape.model.Circle;
import ait.shape.model.Shape;
import ait.shape.model.Square;
import ait.shape.model.Triangle;

public class FigureAppl {
    /*
    Создайте абстрактный класс Shape с полем side типа double и абстрактными методами calcArea и calcPerimeter.
Создайте классы Circle, Triangle, Square, которые наследуют классу Shape и реализуют абстрактные методы.
Напишите класс FigureAppl с методом main. В методе создайте массив фигур. Добавьте в массив два круга, один треугольник и один квадрат.
 Рассчитайте общую площадь и общий периметр всех фигур из массива фигур.
Вычислите общую площадь кругов. (*)
     */
    public static void main(String[] args) {

        Shape [] shapes = new Shape[4];
        shapes[0] = new Circle(7);
        shapes[1] = new Circle(2);
        shapes[2] = new Triangle(5);
        shapes[3] = new Square(6);


        System.out.println(totalArea(shapes));

        System.out.println(totalPerimeter(shapes));

        System.out.println(totalAreaOfCircles(shapes));


    }

    public static String totalArea(Shape [] shapes){
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            sum += shapes[i].calcArea();
        }
        return "Total area = " +sum;
    }

    public static String totalPerimeter(Shape [] shapes){
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            sum += shapes[i].calcPerimeter();
        }
        return "Total perimeter = " + sum;
    }

    public static String totalAreaOfCircles(Shape[] shapes){
        double sum = 0;
        for (int i = 0; i <shapes.length; i++) {
            if(shapes[i] instanceof Circle){
                Shape circle = (Circle) shapes[i];
                sum += circle.calcArea();
            }
        }
        return "Total area of circles is: " + sum;
    }
}
