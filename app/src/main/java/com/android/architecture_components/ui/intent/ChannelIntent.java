package com.android.architecture_components.ui.intent;

import android.content.Context;

import com.android.architecture_components.ui.ChannelActivity;

public class ChannelIntent extends BaseIntent {

    public ChannelIntent(Context context) {
        super(context, ChannelActivity.class);
    }
}
