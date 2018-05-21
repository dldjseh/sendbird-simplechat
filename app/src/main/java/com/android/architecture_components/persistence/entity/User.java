package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity
public class User extends SendBirdObject<com.sendbird.android.User> {

    public User(@NonNull String id, byte[] serializedData) {
        super(id, serializedData);
    }

    @Override
    public com.sendbird.android.User get() {
        return com.sendbird.android.User.buildFromSerializedData(getSerializedData());
    }

    public static User create(com.sendbird.android.User sendBirdUser) {
        return new User(sendBirdUser.getUserId(), sendBirdUser.serialize());
    }
}
