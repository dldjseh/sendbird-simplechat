package com.android.architecture_components.data;

import android.arch.lifecycle.MutableLiveData;

import com.android.architecture_components.persistence.dao.ChannelDao;
import com.android.architecture_components.persistence.entity.Channel;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBird;

public class ChannelEventLiveData extends MutableLiveData<ChannelEvent> {

    private final String TAG = getClass().getSimpleName();

    private final ChannelDao dao;

    private ChannelEventLiveData(ChannelDao dao) {
        this.dao = dao;
    }

    @Override
    protected void onActive() {
        SendBird.addChannelHandler(TAG, new SendBird.ChannelHandler() {
            @Override
            public void onMessageReceived(BaseChannel baseChannel, BaseMessage baseMessage) {

            }

            @Override
            public void onChannelChanged(BaseChannel channel) {
                dao.save(Channel.create((OpenChannel) channel));
                postValue(ChannelEvent.CHANNEL_CHANGED);
            }

            @Override
            public void onChannelDeleted(String channelUrl, BaseChannel.ChannelType channelType) {
                dao.delete(channelUrl);
                postValue(ChannelEvent.CHANNEL_DELETED);
            }
        });
    }

    @Override
    protected void onInactive() {
        SendBird.removeChannelHandler(TAG);
    }

    public static ChannelEventLiveData create(ChannelDao dao) {
        return new ChannelEventLiveData(dao);
    }
}
