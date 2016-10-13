package com.example.harry.rxexample.model;

import java.util.List;

/**
 * Created by Harry on 10/9/16.
 */

public class Person {
    private String name;
    private int age;

    private List<Cat> cats;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
