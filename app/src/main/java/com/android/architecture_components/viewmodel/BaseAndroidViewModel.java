package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.android.architecture_components.repository.Repository;

public class BaseAndroidViewModel<REPO extends Repository> extends AndroidViewModel {

    protected REPO repository;

    protected BaseAndroidViewModel(@NonNull Application application, @NonNull REPO repository) {
        super(application);
        this.repository = repository;
    }
}
