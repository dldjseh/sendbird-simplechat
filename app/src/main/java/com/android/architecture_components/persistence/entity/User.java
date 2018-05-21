package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;

@Entity
public class User extends SendBirdObject {

    public static User create(com.sendbird.android.User sendBirdUser) {
        return new User();
    }
}
