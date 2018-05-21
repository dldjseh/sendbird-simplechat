package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

public abstract class SendBirdObject {

    @NonNull
    @PrimaryKey
    public String id;

    public SendBirdObject(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }
}
