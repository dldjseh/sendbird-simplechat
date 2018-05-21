package com.android.architecture_components.work;

import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.entity.Channel;
import com.sendbird.android.OpenChannel;

public class CreateChannelWorker extends BaseWorker<OpenChannel> {

    public final static String CHANNEL_NAME = "channel_name";

    @NonNull
    @Override
    public WorkerResult doWork() {
        OpenChannel.createChannel(workerHandler);
        return super.doWork();
    }

    @Override
    protected void handleResult(OpenChannel openChannel) {
        ChatDatabase.getInstance(getApplicationContext())
                .getChannelDao()
                .save(Channel.create(openChannel));
    }
}
