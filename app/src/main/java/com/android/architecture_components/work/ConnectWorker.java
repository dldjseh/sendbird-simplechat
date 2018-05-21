package com.android.architecture_components.work;

import android.support.annotation.NonNull;

import com.sendbird.android.SendBird;

public class ConnectWorker extends BaseWorker {

    @NonNull
    @Override
    public WorkerResult doWork() {
        SendBird.connect("Pan", workerHandler);
        return super.doWork();
    }
}
