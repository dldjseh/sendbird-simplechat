package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;

@Entity
public class Message extends SendBirdObject {

    public static Message create() {
        return new Message();
    }
}
