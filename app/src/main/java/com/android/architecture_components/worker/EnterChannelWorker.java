package com.android.architecture_components.worker;

import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBirdException;

public class EnterChannelWorker extends GetChannelWorker {

    @Override
    protected void handleResult(OpenChannel openChannel) {
        openChannel.enter(new OpenChannel.OpenChannelEnterHandler() {
            @Override
            public void onResult(SendBirdException e) {

            }
        });
    }
}
