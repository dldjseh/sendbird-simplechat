package com.android.architecture_components.data;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

import com.android.architecture_components.persistence.entity.SendBirdObject;

public interface SendBirdApi<OBJ extends SendBirdObject> {

    LiveData<PagedList<OBJ>> getAllLiveData();

    LiveData<OBJ> getFirstLiveData();
}
