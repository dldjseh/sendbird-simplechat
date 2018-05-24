package com.android.architecture_components.worker;

import android.support.annotation.NonNull;

import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBirdException;

public abstract class GetChannelWorker extends BaseWorker<OpenChannel> {

    public final static String CHANNEL_ID_KEY = "channel_id";

    @NonNull
    @Override
    public WorkerResult doWork() {
        OpenChannel.getChannel(getString(CHANNEL_ID_KEY), new OpenChannel.OpenChannelGetHandler() {
            @Override
            public void onResult(OpenChannel openChannel, SendBirdException e) {
                handlerException(openChannel, e);
            }
        });
        return super.doWork();
    }
}
