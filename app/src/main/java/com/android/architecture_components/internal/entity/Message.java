package com.android.architecture_components.internal.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.sendbird.android.BaseMessage;

@Entity
public class Message extends SendBirdObject<BaseMessage> {

    @NonNull
    @Override
    BaseMessage get() {
        return BaseMessage.buildFromSerializedData(data);
    }

    public static Message create() {
        return new Message();
    }
}
