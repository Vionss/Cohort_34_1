package ait.list;

import java.util.*;

public class ListAppl {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("Java");
//        list.add("Git");
//        list.add("QA");
//        list.add("SQL");
//        list.add("MongoDB");
//        List<String> list = Arrays.asList("Java", "Git", "QA", "SQL", "MongoDB");
        List<String> list = List.of("Java", "Git", "QA", "SQL", "MongoDB");
        list = new ArrayList<>(list);
        list.add("Spring");
        list.set(0,"Java 11");
        list.forEach(t -> System.out.println(t));
        int[] nums = {5,7};
        int res = sum(2,3, 5,7,11);
        System.out.println("Result = " + res);
        System.out.println("==== Collection ===");
        Collections.sort(list);
        list.forEach(t -> System.out.println(t));
        int index = Collections.binarySearch(list, "JS");
        System.out.println("index = " + index);
        System.out.println("==== Collection sort by Comparator ===");
        Comparator<String> comparator = (s1, s2) -> {
            int r = Integer.compare(s1.length(), s2.length());
            return r != 0 ? r : s1.compareTo(s2);
        };
        Collections.sort(list,comparator);
        list.forEach(t -> System.out.println(t));
        index = Collections.binarySearch(list,"MongoDB", comparator);
        System.out.println("index = " + index);


    }
    public static int sum(int a, int b, int... rest){
        int res = a + b;
        for (int i = 0; i < rest.length; i++) {
            res += rest[i];
        }
        return res;
    }
}
