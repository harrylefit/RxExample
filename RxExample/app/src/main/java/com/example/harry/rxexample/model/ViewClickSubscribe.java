package com.example.harry.rxexample.model;

import android.view.View;

import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/**
 * Created by Harry on 9/29/16.
 */

public class ViewClickSubscribe implements Observable.OnSubscribe<Void> {
    final View view;

    @Override
    public void call(final Subscriber<? super Void> subscriber) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!subscriber.isUnsubscribed()){
                    subscriber.onNext(null);
                }
            }
        };
        view.setOnClickListener(listener);

        subscriber.add(new MainThreadSubscription() {
            @Override
            protected void onUnsubscribe() {
                view.setOnClickListener(null);
            }
        });
    }

    public ViewClickSubscribe(View view) {
        this.view = view;
    }

}
