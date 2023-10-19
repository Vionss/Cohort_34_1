package ait.cars.dao;

import ait.cars.model.Car;

public class GarageImpl implements Garage {

    private Car[] cars;
    private int size;
    public GarageImpl(int capacity) {
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        return false;
    }

    @Override
    public Car removeCar(String regNumber) {
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        return new Car[0];
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return new Car[0];
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return new Car[0];
    }

    @Override
    public Car[] findCarsByColor(String color) {
        return new Car[0];
    }

}
