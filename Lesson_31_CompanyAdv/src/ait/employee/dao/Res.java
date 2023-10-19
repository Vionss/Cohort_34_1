package ait.employee.dao;

import ait.cars.dao.GarageImpl;
import ait.cars.model.Car;

import java.util.Arrays;

public class Res {
    public static void main(String[] args) {
        GarageImpl garage = new GarageImpl(5);
        Car[] cars = new Car[4];
        cars[0] = new Car("001", "Tesla X", "Tesla", 4.0, "White");
        cars[1] = new Car("022", "Supra", "Toyota", 6.3, "Blue");
        cars[2] = new Car("333", "Veyron", "Bugatti", 8.6, "Black");
        cars[3] = new Car("400", "Flying Spur", "Bentley", 5.5, "Red");
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
        System.out.println(Arrays.toString(cars));
    }
    }

