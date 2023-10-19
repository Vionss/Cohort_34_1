package ait.cars.dao;

import ait.cars.model.Car;

import java.util.function.Predicate;

public class GarageImpl implements Garage {

    private Car[] cars;
    private int size;

    public GarageImpl(int capacity) {
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null || cars.length == size || findCarByRegNumber(car.getRegNumber()) != null) {
            return false;
        }
        cars[size++] = car;
        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        Car temp = null;
        for (int i = 0; i < size; i++) {
            if (cars[i] == findCarByRegNumber(regNumber)) {
                temp = cars[i];
                cars[i] = cars[--size];
                cars[size] = null;
                return temp;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber() == regNumber)
                return cars[i];
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        return  findCarsByPredicate(e -> e.getModel().equals(model));
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return findCarsByPredicate(e -> e.getCompany().equals(company));
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return  findCarsByPredicate(e -> e.getEngine() >= min && e.getEngine() < max);
    }

    @Override
    public Car[] findCarsByColor(String color) {
        return findCarsByPredicate(e -> e.getColor().equals(color));
    }

    @Override
    public void printCars() {
        for (int i = 0; i < size; i++) {
            System.out.println(cars[i]);
        }
    }

    @Override
    public int quantity() {
        return size;
    }

    protected Car[] findCarsByPredicate(Predicate<Car> predicate) {
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, j = 0; i < size && j < res.length; i++) {
            if (predicate.test(cars[i])) {
                res[j++] = cars[i];
            }
        }
        return res;
    }
}
