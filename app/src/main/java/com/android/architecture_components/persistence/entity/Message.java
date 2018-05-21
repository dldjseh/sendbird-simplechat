package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity
public class Message extends SendBirdObject {

    public Message(@NonNull String id) {
        super(id);
    }

    public static Message create() {
        return new Message("");
    }
}
