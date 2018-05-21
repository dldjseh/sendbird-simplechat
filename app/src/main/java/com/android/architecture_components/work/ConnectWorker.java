package com.android.architecture_components.work;

import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.ChatDatabase;
import com.sendbird.android.SendBird;
import com.sendbird.android.User;

public class ConnectWorker extends BaseWorker<User> {

    @NonNull
    @Override
    public WorkerResult doWork() {
        SendBird.connect("Pan", workerHandler);
        return super.doWork();
    }

    @Override
    protected void handleResult(User user) {
        ChatDatabase.getInstance(getApplicationContext())
                .getUserDao()
                .save(com.android.architecture_components.persistence.entity.User.create(user));
    }
}