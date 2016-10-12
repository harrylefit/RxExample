package com.example.harry.rxexample.model;


import rx.Observable;

/**
 * Created by Harry on 9/29/16.
 */

public class Cat implements StateCat {
    private String name;
    private boolean alive;
    private boolean run;
    private boolean sleep;

    @Override
    public Observable<Boolean> alive() {
        return alive ? Observable.just(true) : Observable.just(false);
    }

    @Override
    public Observable<Boolean> run() {
        return run ? Observable.just(true) : Observable.just(false);
    }

    @Override
    public Observable<Boolean> sleep() {
        return sleep ? Observable.just(true) : Observable.just(false);
    }

    public Cat(String name, boolean alive, boolean run, boolean sleep) {
        this.name = name;
        this.alive = alive;
        this.run = run;
        this.sleep = sleep;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isRun() {
        return run;
    }

    public boolean isSleep() {
        return sleep;
    }

    public void setName(String name) {
        this.name = name;
    }
}
