package com.example.harry.rxexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;

import com.jakewharton.rxbinding.widget.RxTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvInput)
    AppCompatEditText tvInput;

    @BindView(R.id.tvLog)
    AppCompatTextView tvLog;

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
    }
}
