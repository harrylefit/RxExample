package com.example.harry.rxexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;

import com.example.harry.rxexample.model.Cat;
import com.example.harry.rxexample.model.Person;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewAfterTextChangeEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.functions.Func2;

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


        RxTextView.afterTextChangeEvents(tvInput)
                .filter(event -> !event.editable().toString().equals(""))
                .map(event -> event.editable().toString())
                .subscribe(inputText -> {
                    if (inputText.contains("aaa")) {
                        tvLog.setText("AAA");
                    } else {
                        tvLog.setText("Ops");
                    }
                }, throwable -> {
                    tvLog.setText(throwable.getLocalizedMessage());
                });

//        tvInput.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                try {
//                    if (!s.toString().equals("")) {
//                        if (s.toString().contains("aaa")) {
//                            tvLog.setText("AAA");
//                        } else {
//                            tvLog.setText("Ops");
//                        }
//                    }
//                }catch (Exception ex){
//                    tvLog.setText(ex.getLocalizedMessage());
//                }
//            }
//        });
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
        Observable.combineLatest(RxTextView.afterTextChangeEvents(tvInput), RxTextView.afterTextChangeEvents(tvInput2), new Func2<TextViewAfterTextChangeEvent, TextViewAfterTextChangeEvent, Boolean>() {
            @Override
            public Boolean call(TextViewAfterTextChangeEvent event, TextViewAfterTextChangeEvent event2) {
                return event.editable().toString().contains("xxx") && event.editable().toString().contains("xxx");
            }
        }).subscribe(aBoolean -> {
            if (aBoolean) {
                tvLog.setText("Valid");
            } else {
                tvLog.setText("InValid");
            }
        }, throwable -> {
            tvLog.setText(throwable.getLocalizedMessage());
        });
    }
}
