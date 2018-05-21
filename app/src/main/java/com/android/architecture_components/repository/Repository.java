package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.dao.Dao;
import com.android.architecture_components.persistence.entity.SendBirdObject;
import com.android.architecture_components.work.EkoWorkManager;

import java.util.UUID;

import androidx.work.WorkRequest;
import androidx.work.WorkStatus;

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

    protected final LiveData<WorkStatus> enqueue(WorkRequest request) {
        EkoWorkManager.getInstance().enqueue(request);
        return getWorkStatusById(request.getId());
    }

    protected final void enqueue(WorkRequest... requests) {
        EkoWorkManager.getInstance().enqueue(requests);
    }

    protected final LiveData<WorkStatus> getWorkStatusById(UUID workId) {
        return EkoWorkManager.getInstance().getStatusById(workId);
    }
}
