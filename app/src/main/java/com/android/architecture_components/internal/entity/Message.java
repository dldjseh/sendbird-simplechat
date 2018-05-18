package com.android.architecture_components.internal.entity;

import android.arch.persistence.room.Entity;

import com.sendbird.android.BaseMessage;

@Entity
public class Message extends SendBirdObject<BaseMessage> {

    @Override
    public BaseMessage get() {
        return BaseMessage.buildFromSerializedData(data);
    }

    public static Message create() {
        return new Message();
    }
}
