package com.android.architecture_components.work;

import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.entity.Channel;
import com.sendbird.android.GroupChannel;

import java.util.List;

public class GetAllGroupChannelsWorker extends BaseWorker<List<GroupChannel>> {

    @NonNull
    @Override
    public WorkerResult doWork() {
        GroupChannel.createMyGroupChannelListQuery().next(workerHandler);
        return super.doWork();
    }

    @Override
    protected void handleResult(List<GroupChannel> groupChannels) {
        ChatDatabase.getInstance(getApplicationContext())
                .getChannelDao()
                .save(Channel.create(groupChannels));
    }
}
