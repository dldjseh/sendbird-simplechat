package com.android.architecture_components.ui.intent;

import android.content.Context;

import com.android.architecture_components.ui.ChannelListActivity;

public class ChannelIntent extends BaseIntent {

    public ChannelIntent(Context context) {
        super(context, ChannelListActivity.class);
    }
}
