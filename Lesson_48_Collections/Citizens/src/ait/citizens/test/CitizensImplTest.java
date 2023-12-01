package ait.citizens.test;

import ait.citizens.dao.Citizens;
import ait.citizens.dao.CitizensImpl;
import ait.citizens.dao.CitizensSetImpl;
import ait.citizens.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensImplTest {
    Citizens citizens;
    static final LocalDate now = LocalDate.now();


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        citizens = new CitizensSetImpl();
        Person p1 = new Person(1, "F1", "L1", LocalDate.now().minusYears(31));
        Person p2 = new Person(2, "F2", "L2", LocalDate.now().minusYears(32));
        Person p3 = new Person(3, "F3", "L3", LocalDate.now().minusYears(33));
        Person p4 = new Person(4, "F4", "L4", LocalDate.now().minusYears(34));
        Person p5 = new Person(5, "F5", "L5", LocalDate.now().minusYears(35));
        citizens.add(p1);
        citizens.add(p2);
        citizens.add(p3);
        citizens.add(p4);
        citizens.add(p5);
    }

    @org.junit.jupiter.api.Test
    void testCitizenImplListOfPerson() {
        citizens = new CitizensImpl(List.of(new Person(1, "Peter", "Jackson", now.minusYears(23)),
                new Person(1, "Peter", "Jackson", now.minusYears(23))));
        assertEquals(1, citizens.size());
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertFalse(citizens.add(null));
        assertFalse(citizens.add(new Person(2, "F2", "L2", LocalDate.of(1992, 11, 2))));
        assertEquals(5, citizens.size());
        Person p6 = new Person(6, "F6", "L6", LocalDate.of(1996, 6, 6));
        assertTrue(citizens.add(p6));
        assertEquals(6, citizens.size());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        assertFalse(citizens.remove(6));
        assertTrue(citizens.remove(2));
        assertEquals(4, citizens.size());
    }

    @org.junit.jupiter.api.Test
    void find1() {
        Person p6 = new Person(6, "F6", "L6", LocalDate.of(1996, 6, 6));
        citizens.add(p6);
        assertEquals(p6, citizens.find(6));
        assertNull(citizens.find(7));
    }

    @org.junit.jupiter.api.Test
    void findMinMaxAge() {
        Iterable<Person> actual = citizens.find(31, 33);
        Iterable<Person> expected = List.of(
                new Person(1, "F1", "L1", LocalDate.now().minusYears(31)),
                new Person(2, "F2", "L2", LocalDate.now().minusYears(32)),
                new Person(3, "F3", "L3", LocalDate.now().minusYears(33))
        );
        assertIterableEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test
    void findByLastName() {
        Iterable<Person> actual = citizens.find("L3");
        Iterable<Person> expected = List.of(
                new Person(3, "F3", "L3", LocalDate.now().minusYears(33))
        );
        assertIterableEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getAllPersonsById() {
        Iterable<Person> actual = citizens.getAllPersonsById();
        Iterable<Person> expected = List.of(
                new Person(1, "F1", "L1", LocalDate.of(1991, 10, 3)),
                new Person(2, "F2", "L2", LocalDate.of(1992, 11, 4)),
                new Person(3, "F3", "L3", LocalDate.of(1993, 12, 5)),
                new Person(4, "F4", "L4", LocalDate.of(1994, 12, 5)),
                new Person(5, "F5", "L5", LocalDate.of(1995, 12, 5))
        );
        assertIterableEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getAllPersonsByAge() {
        Iterable<Person> res = citizens.getAllPersonsByAge();
        int age = -1;
        for (Person person : res) {
            assertTrue(person.getAge() >= age);
            age = person.getAge();
        }
    }

    @org.junit.jupiter.api.Test
    void getAllPersonsByLastName() {
        Iterable<Person> actual = citizens.getAllPersonsByLastName();
        String name = "";
        for (Person person : actual) {
            assertTrue(person.getLastName().compareTo(name) >= 0);
            name = person.getLastName();
        }
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(5, citizens.size());
    }
}