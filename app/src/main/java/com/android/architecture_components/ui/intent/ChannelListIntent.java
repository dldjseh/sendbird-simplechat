package com.android.architecture_components.ui.intent;

import android.content.Context;

import com.android.architecture_components.ui.ChannelListActivity;

public class ChannelListIntent extends BaseIntent {

    public ChannelListIntent(Context context) {
        super(context, ChannelListActivity.class);
    }
}
