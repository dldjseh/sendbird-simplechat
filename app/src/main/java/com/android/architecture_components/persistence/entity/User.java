package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity
public class User extends SendBirdObject {

    private User(@NonNull String id, byte[] data) {
        super(id, data);
    }

    public static User create(com.sendbird.android.User sendBirdUser) {
        return new User(sendBirdUser.getUserId(), sendBirdUser.serialize());
    }
}
