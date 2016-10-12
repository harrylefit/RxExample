package com.example.harry.rxexample.model;


import rx.Observable;

/**
 * Created by Harry on 9/29/16.
 */

public interface StateCat {
    Observable<Boolean> alive();
    Observable<Boolean> run();
    Observable<Boolean> sleep();
}
