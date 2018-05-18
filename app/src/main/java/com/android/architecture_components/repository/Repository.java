package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

import com.android.architecture_components.internal.dao.Dao;
import com.android.architecture_components.internal.entity.Message;

public abstract class Repository<DAO extends Dao> {

    protected DAO dao;

    protected Repository(DAO dao) {
        this.dao = dao;
    }

    abstract LiveData<PagedList<Message>> getAll();
}
