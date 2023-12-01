package ait.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAppl {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1,9,2,8,3,7,4,6,5));
       numbers.stream()
               .filter(a -> a > 3)
               .peek(a -> System.out.println("peek before sort: " + a))
               .sorted((n1, n2) -> -Integer.compare(n1, n2))
               .forEach(System.out::println);
        System.out.println("===========================================");
        numbers.forEach(System.out::println);
        System.out.println("===========================================");
        Integer[] arr = {1,9,2,8,3,7,4,6,5};
        Stream<Integer> streamInt = Arrays.stream(arr)
                .filter(n -> n > 2)
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("peek: " + n))
                .sorted((n1, n2) -> -Integer.compare(n1, n2));

       streamInt.forEach(System.out::println);
        System.out.println("============================================");
//        streamInt.forEach(System.out::println);
        Integer res = Arrays.stream(arr)
                .map(n -> n * 10)
                .reduce(0, (accum, n) -> accum + n);
        System.out.println("result " + res);
        res = Arrays.stream(arr)
                .reduce(1, (accum, n) -> accum * n);
        System.out.println("result " + res);

        String str = Arrays.stream(arr)
                .sorted()
                .map(n -> n.toString())
                .reduce("Result = ",(accum, n) -> accum + n );
        System.out.println(str);
        System.out.println("============================================");
        Integer[] sortedNum = Arrays.stream(arr)
                .sorted((n1, n2) -> -Integer.compare(n1,n2))
//              .toArray(size -> new Integer[size]);
                .toArray(Integer[]::new);
        Arrays.stream(sortedNum).forEach(System.out::println);
        System.out.println("============================================");
        res = Arrays.stream(arr)
                .peek(n -> System.out.println("n = " + n))
                .filter(n -> n % 4 == 0)
                .findFirst()
                .orElse(Integer.MAX_VALUE);
        System.out.println(res);

    }
}
