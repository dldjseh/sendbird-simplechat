package com.android.architecture_components.worker;

import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.ChatDatabase;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;

public class ConnectWorker extends BaseWorker<User> {

    @NonNull
    @Override
    public WorkerResult doWork() {
        SendBird.connect("Pan", new SendBird.ConnectHandler() {
            @Override
            public void onConnected(User user, SendBirdException e) {
                handlerException(user, e);
            }
        });
        return super.doWork();
    }

    @Override
    protected void handleResult(User user) {
        ChatDatabase.getInstance(getApplicationContext())
                .getUserDao()
                .save(com.android.architecture_components.persistence.entity.User.create(user));
    }
}
