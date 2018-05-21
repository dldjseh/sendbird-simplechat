package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity
public class User extends SendBirdObject {

    private boolean isActive;

    public User(@NonNull String id, boolean isActive) {
        super(id);
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public static User create(com.sendbird.android.User sendBirdUser) {
        return new User(sendBirdUser.getUserId(), sendBirdUser.isActive());
    }
}
