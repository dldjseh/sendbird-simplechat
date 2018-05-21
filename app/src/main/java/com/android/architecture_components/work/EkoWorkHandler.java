package com.android.architecture_components.work;

import com.sendbird.android.GroupChannel;
import com.sendbird.android.SendBird;

public interface EkoWorkHandler extends SendBird.ConnectHandler,
        GroupChannel.GroupChannelCreateHandler {

}
