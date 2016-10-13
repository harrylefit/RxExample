package com.example.harry.rxexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;

import com.example.harry.rxexample.model.Cat;
import com.example.harry.rxexample.model.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvInput)
    AppCompatEditText tvInput;

    @BindView(R.id.tvInput2)
    AppCompatEditText tvInput2;

    @BindView(R.id.tvLog)
    AppCompatTextView tvLog;

    @BindView(R.id.btnSearch)
    AppCompatButton btnSearch;

    private List<Cat> cats;
    private List<Cat> friendCats;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        cats = new ArrayList<>();
        cats.add(new Cat("Kathy", true, true, false));
        cats.add(new Cat("Kitty", false, false, false));
        cats.add(new Cat("Anthony", true, false, false));

        friendCats = new ArrayList<>();
        friendCats.add(new Cat("Will", true, true, true));
        friendCats.add(new Cat("Kelvin", true, false, false));
        friendCats.add(new Cat("Sarah", false, false, false));

        person = new Person("Harry", 23);


        //TODO 1. duyet mang cats , chi log ra nhung items chua chuoi ki tu 'th',khong phan biet chu hoa,thuong

        //TODO 2. log ra tat ca cac items co ten bat dau bang ki tu 'K', khong phan biet chu hoa,thuong

        //TODO 3. Person co name la: Harry. Person nay muon bat tat ca cac con meo co alive == true. (method person.setCats(cats))
        //TODO sau khi bat duoc tat ca cac con meo co alive == true, ten cua tat cac con meo bat duoc se duoc format theo : Harry_tenhientai.
        //TODO Cuoi cung log ra ten cua tat ca con meo do.

        //TODO 4. duyet mang friendCats. cu moi 2s thi lai co mot con meo co sleep == true. Log ra name cua con meo hien tai co sleep == true. duyet het mang.

        //TODO 5. neu text cua tvInput thay doi va co chua chuoi ki tu 'aaa' -> log ra 'Yeah', nguoc lai 'Ops' bang tvLog

        //TODO 6. dung tvInput log ra : 'Valid' khi ca tvInput vaf tvInput2 deu chua chuoi ki tu 'xxx', nguoc lai log ra: 'Invalid'
    }
}
