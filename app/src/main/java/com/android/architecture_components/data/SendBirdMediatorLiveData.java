package com.android.architecture_components.data;

import android.arch.lifecycle.MediatorLiveData;

import com.android.architecture_components.persistence.entity.SendBirdObject;

public class SendBirdMediatorLiveData<OBJ extends SendBirdObject> extends MediatorLiveData<OBJ> {

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}