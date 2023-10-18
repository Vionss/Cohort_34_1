package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

public class CompanyImpl implements Company {
    private Employee[] employees;
    private int size;

    public CompanyImpl(int capacity) {
        employees = new Employee[capacity];
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || size == employees.length || findEmployee(employee.getId()) != null) {
            return false;
        }
        employees[size++] = employee;
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {
        Employee temp = null;
        for (int i = 0; i < size; i++) {
            if (id == employees[i].getId()) {
                temp = employees[i];
                employees[i] = employees[--size];
                employees[size] = null;
                return temp;
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
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
        for (int i = 0; i < size; i++) {
            if (employees[i] instanceof SalesManager) {
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

    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (employees[i].getHours() > hours) {
                count++;
            }
        }
        Employee[] res = new Employee[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if (employees[i].getHours() > hours) {
                res[j++] = employees[i];
            }
        }
        return res;
    }

    @Override
    public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].calcSalary() >= minSalary && employees[i].calcSalary() < maxSalary) {
                count++;
            }
        }
        Employee[] res = new Employee[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (employees[i].calcSalary() >= minSalary && employees[i].calcSalary() < maxSalary) {
                res[j++] = employees[i];
            }
        }
        return res;
    }
}
