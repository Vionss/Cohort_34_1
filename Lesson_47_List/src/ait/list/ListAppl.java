package ait.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListAppl {
    private static final int N_NUMBERS = 10;
    private static final Random random = new Random();
    private static final int MIN = 10;
    private static final int MAX = 20;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        fillCollection(list);
        printList(list);
    }

    private static void fillCollection(List<Integer> list) {
        for (int i = 0; i < N_NUMBERS; i++) {
            list.add(MIN + random.nextInt(MAX - MIN + 1));
        }

    }
    private static void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.print(num + "\t");
        }
        System.out.println("\n======================================");
    }


}
