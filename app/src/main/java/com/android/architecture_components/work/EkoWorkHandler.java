package com.android.architecture_components.work;

import com.sendbird.android.OpenChannel;
import com.sendbird.android.OpenChannelListQuery;
import com.sendbird.android.SendBird;

public interface EkoWorkHandler extends SendBird.ConnectHandler,
        SendBird.DisconnectHandler,
        OpenChannel.OpenChannelCreateHandler,
        OpenChannelListQuery.OpenChannelListQueryResultHandler {

}
