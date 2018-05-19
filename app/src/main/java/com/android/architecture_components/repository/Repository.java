package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.dao.Dao;
import com.android.architecture_components.persistence.entity.SendBirdObject;

public abstract class Repository<DAO extends Dao, OBJ extends SendBirdObject> {

    protected DAO dao;

    protected Repository(DAO dao) {
        this.dao = dao;
    }

    @Nullable
    public LiveData<PagedList<OBJ>> getAll() {
        return null;
    }

    @Nullable
    public LiveData<OBJ> getFirst() {
        return null;
    }

    public void save(OBJ obj) {

    }
}
