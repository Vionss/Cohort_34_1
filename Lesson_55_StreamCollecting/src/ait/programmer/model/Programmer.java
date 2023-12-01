package ait.programmer.model;

import java.util.Arrays;

public class Programmer {
    String name;
    String[] technologies;

    public Programmer(String name, String... technologies) {
        this.name = name;
        this.technologies = technologies;
    }

    public String getName() {
        return name;
    }

    public String[] getTechnologies() {
        return technologies;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", technologies=" + Arrays.toString(technologies) +
                '}';
    }
}
