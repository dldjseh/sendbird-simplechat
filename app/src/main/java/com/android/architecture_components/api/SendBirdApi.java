package com.android.architecture_components.api;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.entity.SendBirdObject;

public interface SendBirdApi<OBJ extends SendBirdObject> {

    // FIXME: 5/24/18 
    LiveData<PagedList<OBJ>> getAllLiveData(@Nullable String id);

    LiveData<OBJ> getFirstLiveData();
}
