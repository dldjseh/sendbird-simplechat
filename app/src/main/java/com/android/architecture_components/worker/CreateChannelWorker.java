package com.android.architecture_components.worker;

import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.entity.Channel;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBirdException;

public class CreateChannelWorker extends BaseWorker<OpenChannel> {

    public final static String CHANNEL_NAME = "channel_name";

    @NonNull
    @Override
    public WorkerResult doWork() {
        OpenChannel.createChannel(new OpenChannel.OpenChannelCreateHandler() {
            @Override
            public void onResult(OpenChannel openChannel, SendBirdException e) {
                handlerException(openChannel, e);
            }
        });
        return super.doWork();
    }

    @Override
    protected void handleResult(OpenChannel openChannel) {
        ChatDatabase.getInstance(getApplicationContext())
                .getChannelDao()
                .save(Channel.create(openChannel));
    }
}
