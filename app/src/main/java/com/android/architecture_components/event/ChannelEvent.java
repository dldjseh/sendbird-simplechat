package com.android.architecture_components.event;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.SendBird;

public class ChannelEvent extends SendBird.ChannelHandler implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onCreate() {
        SendBird.addChannelHandler(getClass().getSimpleName(), this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onDestroy() {
        SendBird.removeChannelHandler(getClass().getSimpleName());
    }

    @Override
    public void onMessageReceived(BaseChannel baseChannel, BaseMessage baseMessage) {

    }

    @Override
    public void onChannelChanged(BaseChannel channel) {

    }

    @Override
    public void onChannelDeleted(String channelUrl, BaseChannel.ChannelType channelType) {

    }
}
