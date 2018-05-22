package com.android.architecture_components.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.android.architecture_components.data.SendBirdApi;
import com.android.architecture_components.data.repository.BaseRepository;
import com.android.architecture_components.persistence.entity.SendBirdObject;

public abstract class BaseViewModel<OBJ extends SendBirdObject, REPO extends BaseRepository>
        extends AndroidViewModel implements SendBirdApi<OBJ> {

    protected REPO repository;

    BaseViewModel(@NonNull Application application, @NonNull REPO repository) {
        super(application);
        this.repository = repository;
    }
}
