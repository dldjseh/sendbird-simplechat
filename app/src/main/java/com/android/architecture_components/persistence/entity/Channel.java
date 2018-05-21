package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;

@Entity
public class Channel extends SendBirdObject {

    public static Channel create() {
        return new Channel();
    }
}
