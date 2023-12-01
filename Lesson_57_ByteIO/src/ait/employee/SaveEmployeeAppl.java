package ait.employee;

import ait.employee.model.Address;
import ait.employee.model.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class SaveEmployeeAppl {
    public static void main(String[] args) {
        Address address = new Address("Berlin", "Gustav", 23, 15);
        Employee employee1 = new Employee(1,"Peter", LocalDate.of(1990, 5,12), 2500,address);
        Employee employee2 = new Employee(2,"Peter", LocalDate.of(1992, 1,3), 2700.5,address);
        Set<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))){
            oos.writeObject(employees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
