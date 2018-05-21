package com.android.architecture_components.work.sendbird;

import android.support.annotation.NonNull;

import com.android.architecture_components.work.BaseWorker;

public class CreateChannelWorker extends BaseWorker {

    @NonNull
    @Override
    public WorkerResult doWork() {
        return WorkerResult.SUCCESS;
    }
}
