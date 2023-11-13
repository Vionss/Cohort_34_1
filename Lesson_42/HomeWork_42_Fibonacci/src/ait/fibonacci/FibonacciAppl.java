package ait.fibonacci;

import ait.fibonacci.model.Fibonacci;

import java.util.Iterator;

public class FibonacciAppl {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(8);
        //TODO print all numbers and calculate sum
        // 1,1,2,3,5,8,13,21

        Iterator<Integer> iterator = fibonacci.iterator();
        for (int i:fibonacci) {
            System.out.println(i);
        }


    }

}


