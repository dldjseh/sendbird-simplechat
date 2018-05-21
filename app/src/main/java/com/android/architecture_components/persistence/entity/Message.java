package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;

import com.sendbird.android.BaseMessage;

@Entity
public class Message extends SendBirdObject<BaseMessage> {

    @Override
    public BaseMessage get() {
        return BaseMessage.buildFromSerializedData(getSerializedData());
    }

    public static Message create() {
        return new Message();
    }
}
