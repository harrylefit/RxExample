package com.example.harry.rxexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.harry.rxexample.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Cat> cats;
    private List<Cat> friendCats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cats = new ArrayList<>();
        cats.add(new Cat("Kathy", true, true, false));
        cats.add(new Cat("Kitty", false, false, false));
        cats.add(new Cat("Anthony", true, false, false));

        friendCats = new ArrayList<>();
        friendCats.add(new Cat("Will", true, true, true));
        friendCats.add(new Cat("Kelvin", true, false, false));
        friendCats.add(new Cat("Sarah", false, false, false));


    }
}
