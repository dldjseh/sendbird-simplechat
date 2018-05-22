package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.entity.SendBirdObject;

public class BaseAndroidViewModel<OBJ extends SendBirdObject> extends AndroidViewModel {

    protected BaseAndroidViewModel(@NonNull Application application) {
        super(application);
    }

    @Nullable
    public LiveData<PagedList<OBJ>> getAllLiveData() {
        return null;
    }

    @Nullable
    public LiveData<OBJ> getFirstLiveData() {
        return null;
    }
}
