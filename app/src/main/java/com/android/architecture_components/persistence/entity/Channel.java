package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.GroupChannel;

@Entity
public class Channel extends SendBirdObject<BaseChannel> {

    public Channel(@NonNull String id, byte[] serializedData) {
        super(id, serializedData);
    }

    @Override
    public BaseChannel get() {
        return BaseChannel.buildFromSerializedData(getSerializedData());
    }

    public static Channel create(GroupChannel groupChannel) {
        return new Channel(groupChannel.getUrl(), groupChannel.serialize());
    }
}
