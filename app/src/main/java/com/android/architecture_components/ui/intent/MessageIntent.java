package com.android.architecture_components.ui.intent;

import android.content.Context;
import android.content.Intent;

import com.android.architecture_components.ui.MessageListActivity;

public class MessageIntent extends BaseIntent {

    private static final String CHANNEL_ID_EXTRA = "channel_id";

    public MessageIntent(Context context, String channelId) {
        super(context, MessageListActivity.class);
        putExtra(CHANNEL_ID_EXTRA, channelId);
    }

    public static String getChannelId(Intent intent) {
        return intent.getStringExtra(CHANNEL_ID_EXTRA);
    }
}
