package com.android.architecture_components.event;

import android.arch.lifecycle.MutableLiveData;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.SendBird;

public class ChannelLiveEvent extends MutableLiveData<ChannelEvent> {

    private final String TAG = getClass().getSimpleName();

    private final MutableLiveData<BaseMessage> messageReceivedLiveEvent = new MutableLiveData<>();
    private final MutableLiveData<BaseChannel> channelChangedLiveEvent = new MutableLiveData<>();
    private final MutableLiveData<String> channelDeletedLiveEvent = new MutableLiveData<>();

    private ChannelLiveEvent() {

    }

    public MutableLiveData<BaseMessage> getMessageReceivedLiveEvent() {
        return messageReceivedLiveEvent;
    }

    public MutableLiveData<BaseChannel> getChannelChangedLiveEvent() {
        return channelChangedLiveEvent;
    }

    public MutableLiveData<String> getChannelDeletedLiveEvent() {
        return channelDeletedLiveEvent;
    }

    @Override
    protected void onActive() {
        SendBird.addChannelHandler(TAG, new SendBird.ChannelHandler() {
            @Override
            public void onMessageReceived(BaseChannel baseChannel, BaseMessage baseMessage) {
                messageReceivedLiveEvent.setValue(baseMessage);
                setValue(ChannelEvent.MESSAGE_RECEIVED);
            }

            @Override
            public void onChannelChanged(BaseChannel channel) {
                channelChangedLiveEvent.setValue(channel);
                setValue(ChannelEvent.CHANNEL_CHANGED);
            }

            @Override
            public void onChannelDeleted(String channelUrl, BaseChannel.ChannelType channelType) {
                channelDeletedLiveEvent.setValue(channelUrl);
                setValue(ChannelEvent.CHANNEL_DELETED);
            }
        });
    }

    @Override
    protected void onInactive() {
        SendBird.removeChannelHandler(TAG);
    }

    public static ChannelLiveEvent create() {
        return new ChannelLiveEvent();
    }
}
