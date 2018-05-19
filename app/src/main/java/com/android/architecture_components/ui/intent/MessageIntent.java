package com.android.architecture_components.ui.intent;

import android.content.Context;

import com.android.architecture_components.ui.MessageActivity;

public class MessageIntent extends BaseIntent {

    public MessageIntent(Context context) {
        super(context, MessageActivity.class);
    }
}
