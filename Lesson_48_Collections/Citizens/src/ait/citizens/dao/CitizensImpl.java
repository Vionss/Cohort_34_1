package ait.citizens.dao;

import ait.citizens.model.Person;

import java.time.LocalDate;
import java.util.*;

public class CitizensImpl implements Citizens{
    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;
    private static Comparator<Person> lastNameComparator = (p1,p2) -> p1.getLastName().compareTo(p2.getLastName());
    private static Comparator<Person> ageComparator = (p1, p2) ->{
        int res = Integer.compare(p1.getAge(), p2.getAge());
        return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
    };


    public CitizensImpl(){
        idList =  new ArrayList<>();
        lastNameList = new ArrayList<>();
        ageList = new ArrayList<>();
    }
    public CitizensImpl(List<Person> citizens){
        this();
        citizens.forEach(p -> add(p));
    }
    @Override
    public boolean add(Person person) {
        if(person == null){
            return false;
        }
        int index = Collections.binarySearch(idList, person);
        if(index >=0){
            return false;
        }
        index = -index -1;
        idList.add(index, person);
        index = Collections.binarySearch(ageList,person, ageComparator);
        index = index >= 0 ? index : -index -1;
        ageList.add(index, person);
        index = Collections.binarySearch(lastNameList, person, lastNameComparator);
        index = index >= 0 ? index : -index -1;
        lastNameList.add(index, person);
        return true;
    }

    @Override
    public boolean remove(int id) {
        Person victim = find(id);
        if(victim == null){
            return false;
        }
        idList.remove(victim);
        ageList.remove(victim);
        lastNameList.remove(victim);
        return true;
    }

    @Override
    public Person find(int id) {
        Person pattern = new Person(id,null,null,null);
        int index = Collections.binarySearch(idList, pattern);
        return index < 0 ? null : idList.get(index);

    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        LocalDate now = LocalDate.now();
        Person pattern = new Person(Integer.MIN_VALUE, null,null, now.minusYears(minAge));
        int from = -Collections.binarySearch(ageList, pattern, ageComparator) - 1;
        pattern = new Person(Integer.MAX_VALUE, null,null, now.plusYears(maxAge));
        int to = -Collections.binarySearch(ageList, pattern, ageComparator) - 1;
        return ageList.subList(from,to);
    }

    @Override
    public Iterable<Person> find(String lastName) {
        // TODO
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsById() {
        return idList;
    }

    @Override
    public Iterable<Person> getAllPersonsByAge() {
        return ageList;
    }

    @Override
    public Iterable<Person> getAllPersonsByLastName() {
        return lastNameList;
    }

    @Override
    public int size() {
        return idList.size();
    }

}
