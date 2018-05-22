package com.android.architecture_components.work;

import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.entity.Channel;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.OpenChannelListQuery;
import com.sendbird.android.SendBirdException;

import java.util.List;

public class GetAllChannelsWorker extends BaseWorker<List<OpenChannel>> {

    @NonNull
    @Override
    public WorkerResult doWork() {
        OpenChannel.createOpenChannelListQuery().next(new OpenChannelListQuery.OpenChannelListQueryResultHandler() {
            @Override
            public void onResult(List<OpenChannel> list, SendBirdException e) {
                handlerException(list, e);
            }
        });
        return super.doWork();
    }

    @Override
    protected void handleResult(List<OpenChannel> openChannels) {
        ChatDatabase.getInstance(getApplicationContext())
                .getChannelDao()
                .save(Channel.create(openChannels));
    }
}
