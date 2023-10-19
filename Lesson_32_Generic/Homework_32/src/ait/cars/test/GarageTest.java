package ait.cars.test;

import ait.cars.dao.Garage;
import ait.cars.dao.GarageImpl;
import ait.cars.model.Car;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage garage;
    Car[] cars;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        garage = new GarageImpl(5);
        cars = new Car[4];
        cars[0] = new Car("001", "Tesla X", "Tesla", 4.0, "White");
        cars[1] = new Car("022", "Supra", "Toyota", 6.3, "Blue");
        cars[2] = new Car("333", "Veyron", "Bugatti", 8.6, "Black");
        cars[3] = new Car("400", "Flying Spur", "Bentley", 5.5, "Red");
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
        System.out.println(cars);
    }

    @org.junit.jupiter.api.Test
    void addCar() {
        assertFalse(garage.addCar(null));
        assertFalse(garage.addCar(cars[3]));
        Car car = new Car("500", "Megan", "Renault", 1.7, "Black");
        assertTrue(garage.addCar(car));
        assertEquals(5, garage.quantity());
        car = new Car("500", "Megan", "Renault", 1.7, "Black");
        assertFalse(garage.addCar(car));

    }

    @org.junit.jupiter.api.Test
    void removeCar() {
        Car car = garage.removeCar("022");
        assertEquals(cars[1], car);
        assertEquals(3, garage.quantity());
        assertNull(garage.removeCar("022"));

    }

    @org.junit.jupiter.api.Test
    void findCarByRegNumber() {
        assertNull(garage.findCarByRegNumber("900"));
        assertEquals(cars[0], garage.findCarByRegNumber("001"));
    }

    @org.junit.jupiter.api.Test
    void findCarsByModel() {
        Car[] actual = garage.findCarsByModel("Tesla X");
        Car[] expected = {cars[0]};
        assertArrayEquals(expected,actual);

    }

    @org.junit.jupiter.api.Test
    void findCarsByCompany() {
        Car[] actual = garage.findCarsByCompany("Toyota");
        Car[] expected = {cars[1]};
        assertArrayEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void findCarsByEngine() {
        Car[] actual = garage.findCarsByEngine(6.5, 9.0);
        Car[] expected = {cars[2]};
        assertArrayEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void findCarsByColor() {
        Car[] actual = garage.findCarsByColor("Red");
        Car[] expected = {cars[3]};
        assertArrayEquals(expected,actual);
    }
}