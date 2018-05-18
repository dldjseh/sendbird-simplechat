package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

import com.android.architecture_components.internal.dao.Dao;
import com.android.architecture_components.internal.entity.SendBirdObject;

public abstract class Repository<DAO extends Dao, OBJ extends SendBirdObject> {

    protected DAO dao;

    protected Repository(DAO dao) {
        this.dao = dao;
    }

    abstract public LiveData<PagedList<OBJ>> getAll();

    abstract public void save(OBJ obj);
}
