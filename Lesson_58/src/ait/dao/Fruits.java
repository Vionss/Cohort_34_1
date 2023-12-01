package ait.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Fruits {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("pear");
        fruits.add("plum");
        fruits.add("strawberry");
        System.out.println("--------------------");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println("--------------------");

        Collections.sort(fruits);
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println("--------------------");

        int index= Collections.binarySearch(fruits,"banana");
        System.out.println(index);

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        };

        Collections.sort(fruits, comparator);
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println("--------------------");

        String max =  Collections.max(fruits);
        System.out.println(max);
        String min =  Collections.min(fruits);
        System.out.println(min);

    }
}
