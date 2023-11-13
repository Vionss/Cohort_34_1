package ait.fibonacci.model;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {


    private int quantity;
    private int index = 1;
    private int currNum = 1;
    private int nextNum = 1;


    public FibonacciIterator(int quantity) {
        this.quantity = quantity;

    }

    @Override
    public boolean hasNext() {
        return index <= quantity;
    }


    // 1,2,3,5,8,13,21
    @Override
    public Integer next() {
        Integer prev = currNum;
        System.out.println(currNum);
        Integer next = nextNum;
        Integer third = prev + next;
        System.out.println(third);
        index++;
        next = third;
        third = prev + next;

        return third;
    }
}
    // 1,2,3,5,8,13,21