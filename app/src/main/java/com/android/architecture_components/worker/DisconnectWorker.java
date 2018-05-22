package com.android.architecture_components.worker;

import android.support.annotation.NonNull;

import com.sendbird.android.SendBird;
import com.sendbird.android.User;

public class DisconnectWorker extends BaseWorker<User> {

    @NonNull
    @Override
    public WorkerResult doWork() {
        SendBird.disconnect(new SendBird.DisconnectHandler() {
            @Override
            public void onDisconnected() {
                handleResult();
            }
        });
        return super.doWork();
    }

    @Override
    protected void handleResult() {

    }
}
