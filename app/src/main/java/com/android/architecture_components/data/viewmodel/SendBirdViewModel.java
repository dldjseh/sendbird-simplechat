package com.android.architecture_components.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.android.architecture_components.data.SendBirdApi;
import com.android.architecture_components.persistence.entity.SendBirdObject;

public abstract class SendBirdViewModel<OBJ extends SendBirdObject> extends AndroidViewModel
        implements SendBirdApi<OBJ> {

    SendBirdViewModel(@NonNull Application application) {
        super(application);
    }
}
