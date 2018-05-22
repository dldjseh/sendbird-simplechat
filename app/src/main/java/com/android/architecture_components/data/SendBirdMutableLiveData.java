package com.android.architecture_components.data;

import android.arch.lifecycle.MutableLiveData;

import com.android.architecture_components.persistence.entity.SendBirdObject;

public class SendBirdMutableLiveData<OBJ extends SendBirdObject> extends MutableLiveData<OBJ> {

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}
