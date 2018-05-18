package com.android.architecture_components.internal.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.sendbird.android.BaseChannel;

@Entity
public class Channel extends SendBirdObject<BaseChannel> {

    @NonNull
    @Override
    BaseChannel get() {
        return BaseChannel.buildFromSerializedData(data);
    }

    public static Channel create() {
        return new Channel();
    }
}
