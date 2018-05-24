package com.android.architecture_components.service;

import android.app.Notification;
import android.app.Service;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.architecture_components.event.ChannelEvent;
import com.android.architecture_components.event.ChannelLiveEvent;
import com.android.architecture_components.repository.ChannelListRepository;
import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.dao.ChannelDao;
import com.sendbird.android.BaseChannel;

public class LiveEventService extends Service implements LifecycleOwner {

    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startForeground(1, new Notification());
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);

        final ChannelDao channelDao = ChatDatabase.getInstance(this).getChannelDao();
        final ChannelListRepository channelRepository = new ChannelListRepository(channelDao);

        ChannelLiveEvent channelLiveEvent = channelRepository.getLiveEvent();

        channelLiveEvent.observe(this, new Observer<ChannelEvent>() {
            @Override
            public void onChanged(@Nullable ChannelEvent channelEvent) {

            }
        });

        channelLiveEvent.getChannelChangedLiveEvent()
                .observe(this, new Observer<BaseChannel>() {
                    @Override
                    public void onChanged(@Nullable BaseChannel baseChannel) {

                    }
                });

        channelLiveEvent.getChannelDeletedLiveEvent()
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String channelId) {

                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }
}
