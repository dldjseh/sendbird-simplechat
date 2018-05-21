package com.android.architecture_components.work;

import android.support.annotation.NonNull;

import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannelParams;

public class CreateChannelWorker extends BaseWorker {

    public final static String CHANNEL_NAME = "channel_name";

    @NonNull
    @Override
    public WorkerResult doWork() {
        GroupChannelParams params = new GroupChannelParams();
        params.setName(getString(CHANNEL_NAME));
        GroupChannel.createChannel(params, workerHandler);
        return super.doWork();
    }
}
