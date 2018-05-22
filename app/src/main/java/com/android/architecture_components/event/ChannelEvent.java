package com.android.architecture_components.event;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.SendBird;

public class ChannelEvent extends SendBird.ChannelHandler {

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
