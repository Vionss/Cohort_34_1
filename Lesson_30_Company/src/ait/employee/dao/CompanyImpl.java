package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

import javax.sound.midi.Soundbank;

public class CompanyImpl implements Company{
    private Employee[] employees;
    private int size;
    public CompanyImpl(int capacity){
        employees = new Employee[capacity];
    }
    @Override
    public boolean addEmployee(Employee employee) {
        if(employee == null || size == employees.length || findEmployee(employee.getId()) != null){
            return false;
        }
        employees[size] = employee;
        size++;
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {
        Employee temp = null;
        for (int i = 0; i < size; i++) {
            if( id == employees[i].getId()){
              temp =  employees[i];
              employees[i] = employees[size -1];
              employees[size -1] = null;
              size--;
              break;
            }
        }
        return temp;
    }

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getId() == id){
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public double totalSalary() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
                sum += employees[i].calcSalary();
        }
        return sum;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public double avgSalary() {
        double sum = totalSalary() / size;
        return sum;
    }

    @Override
    public double totalSales() {
        double sum = 0;
        for (int i = 0; i < size ; i++) {
            if(employees[i] instanceof SalesManager){
                SalesManager sm = (SalesManager) employees[i];
                sum += sm.getSalesValue();
            }
        }
        return sum;
    }

    @Override
    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}
