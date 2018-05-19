package com.android.architecture_components;

import android.app.Application;

import com.sendbird.android.SendBird;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SendBird.init(getString(R.string.send_bird_app_id), this);
    }
}
