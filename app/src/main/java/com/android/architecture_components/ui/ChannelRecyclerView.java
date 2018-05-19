package com.android.architecture_components.ui;

import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.persistence.entity.Message;

public interface ChannelRecyclerView extends BaseRecyclerView<Message> {

    void createChannel(Channel channel);

    void joinChannel(String channelId);
}
