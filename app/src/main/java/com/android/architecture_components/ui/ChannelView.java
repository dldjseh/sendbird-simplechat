package com.android.architecture_components.ui;

import com.android.architecture_components.internal.entity.Channel;
import com.android.architecture_components.internal.entity.Message;

public interface ChannelView extends BaseView<Message> {

    void createChannel(Channel channel);

    void joinChannel(String channelId);
}
