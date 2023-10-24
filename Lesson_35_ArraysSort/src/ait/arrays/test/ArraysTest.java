package ait.arrays.test;

import ait.soldier.model.Soldier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.ObjectName;
import java.util.Arrays;
import java.util.Comparator;

public class ArraysTest {
    Integer[] arrNum;
    String[] arrStr;
    Soldier[] soldiers;

    @BeforeEach
    void setUp() {
        arrNum = new Integer[]{9, 7, 4, 7, 2, 5, 1, 0};
        arrStr = new String[]{"one", "two", "three", "four", "five"};
        soldiers = new Soldier[]{
                new Soldier("John", 182, 82.3, 91),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("Rabindranate", 162, 55.1, 91),
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Ann", 162, 55, 88)
        };
    }

    @Test
    void testArraysSort() {
        Arrays.sort(arrNum);
        System.out.println(Arrays.toString(arrNum));
        Arrays.sort(arrStr);
        System.out.println(Arrays.toString(arrStr));
    }

    @Test
    void testArraysSortComparator() {
        Arrays.sort(arrNum, (n1, n2) -> n2 - n1);
        System.out.println(Arrays.toString(arrNum));
        Arrays.sort(arrStr, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(arrStr));
    }

    @Test
    void testSortSoldiersNaturalOrder() {
        Arrays.sort(soldiers);
        printArray(soldiers);
    }

    @Test
    void testSoldiersByName() {
        Arrays.sort(soldiers, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        printArray(soldiers);
    }

    @Test
    void testSoldiersByProfile() {
        Arrays.sort(soldiers, (s1, s2) -> {
            int res = s2.getProfile() - s1.getProfile();
            return res != 0 ? res : s1.getHeight() - s2.getHeight();
        });
        printArray(soldiers);
    }

    @Test
    void testSoldiersByWeight() {
        Arrays.sort(soldiers, (s1, s2) -> Double.compare(s1.getWeight(), s2.getWeight()));
        printArray(soldiers);
    }

    @Test
    void testOdEvenComparator() {
        Integer[] origin = {1, 4, 3, 2, 5, 6, 9, 8, 7, 3};
        Comparator<Integer> comparator = (n1, n2) -> {
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            }
            if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }
            return 0;
        };
        Arrays.sort(origin, comparator);
        System.out.println(Arrays.toString(origin));
    }

    @Test
    void testOdEvenComparator2() {
        Integer[] origin = {1, 4, 3, 2, 5, 6, 9, 8, 7, 3};
        Comparator<Integer> comparator = (n1, n2) -> {
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            }
            if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }
            if (n1 % 2 == 0 && n2 % 2 == 0) {
                return n1 - n2;
            }
            if (n1 % 2 != 0 && n2 % 2 != 0) {
                return n2 - n1;
            }
            return 0;
        };
        Arrays.sort(origin, comparator);
        System.out.println(Arrays.toString(origin));
    }

    private void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("====================================");
    }
}
