package ait.programmer;

import ait.programmer.model.Programmer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProgrammerAppl {
    public static void main(String[] args) {
        List<Programmer> programmers = getProgrammers();
        System.out.println("==== Most Skilled Programmers ===");
        printMostSkilledProgrammers(programmers);
        System.out.println("==== Most Popular Technologies ===");
        printMostPopularTechnologies(programmers);
    }

    private static void printMostPopularTechnologies(List<Programmer> programmers) {
        System.out.println("=== Print all technologies ===");
        Iterable<String> technologies = programmers.stream()
                .map(p -> p.getTechnologies())
                .flatMap(t -> Arrays.stream(t))
                .collect(Collectors.toList());
        StreamSupport.stream(technologies.spliterator(),false)
                .distinct()
                .forEach(System.out::println);
        System.out.println("=== Grouping By ===");
        Map<String, Long> techFrequency = programmers.stream()
                .map(Programmer::getTechnologies)
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()));
        Long max = techFrequency.values().stream()
                .max(Long::compare).orElse(0L);
        techFrequency.entrySet().stream()
                .filter(e -> max.equals(e.getValue()))
                .forEach(e -> System.out.println(e.getKey()));
    }

    private static void printMostSkilledProgrammers(List<Programmer> programmers) {
        Map<Integer, List<Programmer>> skilledProgrammers = programmers.stream()
                .collect(Collectors.groupingBy(p -> p.getTechnologies().length));
        Integer max = skilledProgrammers.keySet().stream()
                .max(Integer::compare).orElse(0);

//        Map<Integer, List<Programmer>> skilledProgrammers = new HashMap<>();
//        int max = 0;
//        for (Programmer programmer : programmers) {
//            int size = programmer.getTechnologies().length;
//            max = size > max ? size : max;
//            skilledProgrammers.putIfAbsent(size, new ArrayList<>());
//            // skilledProgrammers.get(size).add(programmer);
//            List<Programmer> programmerList = skilledProgrammers.get(size);
//            programmerList.add(programmer);
//
//        }
        skilledProgrammers.get(max).forEach(System.out::println);
    }

    private static List<Programmer> getProgrammers() {
        return List.of(
                new Programmer("Peter", "C++", "Python", "Java", "Kotlin"),
                new Programmer("John", "Python", "Java"),
                new Programmer("Helen", "Kotlin", "Scala", "Java", "Javascript"),
                new Programmer("Jacob", "Python", "Go"),
                new Programmer("Petrovich", "Fortran", "Algol", "PL-1")

        );
    }
}
