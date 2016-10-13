package com.example.harry.rxexample;


import com.example.harry.rxexample.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harry on 10/9/16.
 */

public class DummyFactory {

    public static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Danny", 25));
        persons.add(new Person("Harry", 23));
        persons.add(new Person("John", 24));
        persons.add(new Person("Iris", 24));
        persons.add(new Person("Anthony", 24));
        persons.add(new Person("Ray", 22));
        persons.add(new Person("Ben", 22));
        persons.add(new Person("Nicholas", 24));
        persons.add(new Person("Louis", 24));
        return persons;
    }
}
