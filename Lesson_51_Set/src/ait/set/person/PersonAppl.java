package ait.set.person;

import ait.set.person.model.Person;

import java.util.HashSet;
import java.util.Set;

public class PersonAppl {
    public static void main(String[] args) {
        Person romeo = new Person(1,"Romeo", "Montague");
        Person juliet = new Person(2,"Juliet", "Capulet");
        Set<Person> persons = new HashSet<>();
        persons.add(romeo);
        persons.add(juliet);
        System.out.println(persons.contains(romeo));
        System.out.println(persons.contains(juliet));
        System.out.println("=========================");
        juliet.setLastName("Montague");
        System.out.println(persons.contains(romeo));
        System.out.println(persons.contains(juliet));
        System.out.println("=========================");
        System.out.println(persons.size());
        persons.forEach(p -> System.out.println(p));


    }
}
