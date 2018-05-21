package com.android.architecture_components.work.sendbird;

import android.support.annotation.NonNull;

import com.android.architecture_components.work.BaseWorker;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;

import io.reactivex.subjects.PublishSubject;

public class ConnectWorker extends BaseWorker {

    @NonNull
    @Override
    public WorkerResult doWork() {
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

        try {
            publishSubject.blockingFirst();
            return WorkerResult.SUCCESS;
        } catch (Exception e) {
            return WorkerResult.FAILURE;
        }
    }
}
