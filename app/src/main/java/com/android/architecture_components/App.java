package com.android.architecture_components;

import android.app.Application;
import android.content.Intent;
import android.support.v4.content.ContextCompat;

import com.android.architecture_components.service.ChannelLiveEventService;
import com.sendbird.android.SendBird;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SendBird.init(getString(R.string.send_bird_app_id), this);

        Intent intent = new Intent(this, ChannelLiveEventService.class);
        ContextCompat.startForegroundService(this, intent);
    }
}
