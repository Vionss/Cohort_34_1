package ait.computer.model;

public class Laptop extends Computer {
    private double hours;
    private double weight;

    public Laptop(String cpu, int ram, int ssd, String brand, double hours, double weight) {
        super(cpu, ram, ssd, brand);
        this.hours = hours;
        this.weight = weight;
    }

    public double getHours() {
        return hours;
    }


    public double getWeight() {
        return weight;
    }

    public String toString() {
        return super.toString() + ", Hours: " + hours + ", Weight: " + weight;
    }

    public void setHours(double v) {
    }

    public boolean equals(Object object) {
        if (!(object instanceof Laptop)) {
            return false;
        }
       Laptop other = (Laptop) object;
        return super.equals(other) && hours == other.hours && weight == other.weight;
    }
}