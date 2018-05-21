package com.android.architecture_components.work;

import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.entity.Channel;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannelParams;

public class CreateGroupChannelWorker extends BaseWorker<GroupChannel> {

    public final static String CHANNEL_NAME = "channel_name";

    @NonNull
    @Override
    public WorkerResult doWork() {
        GroupChannelParams params = new GroupChannelParams();
        params.setName(getString(CHANNEL_NAME));
        GroupChannel.createChannel(params, workerHandler);
        return super.doWork();
    }

    @Override
    protected void handleResult(GroupChannel groupChannel) {
        ChatDatabase.getInstance(getApplicationContext())
                .getChannelDao()
                .save(Channel.create(groupChannel));
    }
}
