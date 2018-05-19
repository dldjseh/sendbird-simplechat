package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

public abstract class SendBirdObject {

    @NonNull
    @PrimaryKey
    public String id;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] serializedData;

    protected SendBirdObject() {
    }

    protected SendBirdObject(@NonNull String id, byte[] serializedData) {
        this.id = id;
        this.serializedData = serializedData;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public byte[] getSerializedData() {
        return serializedData;
    }

    public void setSerializedData(byte[] serializedData) {
        this.serializedData = serializedData;
    }
}
