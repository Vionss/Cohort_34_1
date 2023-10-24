package ait.arrays.test;

import ait.arrays.util.ArrayTools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class ArrayToolsTest {

    Integer[] arrNum;
    String[] arrStr;

    @BeforeEach
    void setUp() {
        arrNum = new Integer[]{9, 7, 4, 7, 2, 5, 1, 0};
        arrStr = new String[]{"one", "two", "three", "four", "five"};
    }

    @Test
    void testPrintArray() {
        System.out.println("=== testPrintArray ===");
        ArrayTools.printArray(arrNum);
        ArrayTools.printArray(arrStr);
    }

    @Test
    void testSearch() {
        System.out.println("=== testSearch ===");
        int index = ArrayTools.search(arrStr, "four");
        System.out.println("index = " + index);
    }

    @Test
    void testFindByPredicate() {
        System.out.println("=== testFindByPredicate ===");
        Integer num = ArrayTools.findByPredicate(arrNum, n -> n < 5);
        System.out.println(num);
        num = ArrayTools.findByPredicate(arrNum, n -> n % 5 == 0);
        System.out.println(num);
        String str = ArrayTools.findByPredicate(arrStr, s -> s.length() == 4);
        System.out.println(str);
    }

    @Test
    void testBubbleSort() {
        System.out.println("=== testBubbleSort ===");
        ArrayTools.bubbleSort(arrNum);
        ArrayTools.printArray(arrNum);
        ArrayTools.bubbleSort(arrStr);
        ArrayTools.printArray(arrStr);
    }

    @Test
    void testBubbleSortCpmparator() {
        System.out.println("=== testBubbleSortComparator===");
        ArrayTools.bubbleSort(arrNum, (n1, n2) -> n2 - n1);
        ArrayTools.printArray(arrNum);
        ArrayTools.bubbleSort(arrStr, (s1, s2) -> s1.length() - s2.length());
        ArrayTools.printArray(arrStr);
    }
    /*
    Напишите OddEvenComparator, реализующий Comparator с методом сравнения для сортировки массива целых чисел в следующем порядке: Четные целые числа должны идти перед нечетными числами.
     */
    @Test
    void testOddEvenComparator(){
        System.out.println("=== testOddEvenComparator ===");

        ArrayTools.OddEvenComparator(arrNum, (n1, n2) -> {
            if (n1 % 2 == 0 && n2 % 2 == 0) {
                return n1 - n2;
            } else if (n1 % 2 != 0 && n2 % 2 != 0) {
                return n2 - n1;
            } else {
                if (n1 % 2 == 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        ArrayTools.printArray(arrNum);
    }
}