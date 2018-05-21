package com.android.architecture_components;

import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.subjects.PublishSubject;

public class RxSendBird {

    public static Flowable<User> connect() {
        final PublishSubject<User> publishSubject = PublishSubject.create();
        SendBird.connect("Pan", new SendBird.ConnectHandler() {
            @Override
            public void onConnected(User user, SendBirdException e) {
                if (e != null) {
                    publishSubject.onError(e);
                } else {
                    publishSubject.onNext(user);
                    publishSubject.onComplete();
                }
            }
        });
        return publishSubject.toFlowable(BackpressureStrategy.MISSING);
    }
}
