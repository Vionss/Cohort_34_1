package ait.employee.model;

public class SalesManager extends Employee {
    private double salesValue;
    private double percent;

    public SalesManager(int id, String firstName, String lastname, double hours, double salesValue, double percent) {
        super(id, firstName, lastname, hours);
        this.salesValue = salesValue;
        this.percent = percent;
    }

    public double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(double salesValue) {
        this.salesValue = salesValue;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public double calcSalary() {
        double salary = salesValue * percent;
        if (salary < hours * minWage) {
            salary = hours * minWage;
        }
        return salary;
    }
}
