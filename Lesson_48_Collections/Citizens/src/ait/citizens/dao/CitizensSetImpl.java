package ait.citizens.dao;

import ait.citizens.model.Person;

import java.time.LocalDate;
import java.util.*;

public class CitizensSetImpl implements Citizens{
    private TreeSet<Person> idList;
    private TreeSet<Person> lastNameList;
    private TreeSet<Person> ageList;
    private static Comparator<Person> lastNameComparator = (p1, p2) -> {
        int res = p1.getLastName().compareTo(p2.getLastName());
        return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
    };

    private static Comparator<Person> ageComparator = (p1, p2) ->{
        int res = Integer.compare(p1.getAge(), p2.getAge());
        return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
    };


    public CitizensSetImpl(){
        idList =  new TreeSet<>();
        lastNameList = new TreeSet<>(lastNameComparator);
        ageList = new TreeSet<>(ageComparator);
    }
    public CitizensSetImpl(List<Person> citizens){
        this();
        citizens.forEach(p -> add(p));
    }

    // O(1) + 3 * O(log(n)) = O(log(n))
    @Override
    public boolean add(Person person) {
        return person != null && idList.add(person) && lastNameList.add(person) && ageList.add(person);
    }

    // O(log(n))
    @Override
    public boolean remove(int id) {
        Person victim = find(id);
        return victim != null && idList.remove(victim) && lastNameList.remove(victim) && ageList.remove(victim);
    }

    // O(log(n))
    @Override
    public Person find(int id) {
        Person pattern = new Person(id,null,null,null);
        Person person = idList.ceiling(pattern);
        return pattern.equals(person)? person : null;

    }

    // O(log(n))
    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        LocalDate now = LocalDate.now();
        Person from = new Person(idList.first().getId(), null,null, now.minusYears(minAge));
        Person to = new Person(idList.last().getId(), null,null, now.minusYears(maxAge));
        return ageList.subSet(from,to);
    }

    // O(log(n))
    @Override
    public Iterable<Person> find(String lastName) {
        Person from = new Person(idList.first().getId(), null,lastName, null);
        Person to = new Person(idList.last().getId(), null,lastName, null);
        return lastNameList.subSet(from, true,to,true);
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonsById() {
        return idList;
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonsByAge() {
        return ageList;
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonsByLastName() {
        return lastNameList;
    }

    // O(1)
    @Override
    public int size() {
        return idList.size();
    }
}
