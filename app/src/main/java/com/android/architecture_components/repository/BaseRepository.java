package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;

import com.android.architecture_components.api.SendBirdApi;
import com.android.architecture_components.persistence.dao.Dao;
import com.android.architecture_components.persistence.entity.SendBirdObject;
import com.android.architecture_components.worker.SendBirdWorkManager;

import java.util.UUID;

import androidx.work.WorkRequest;
import androidx.work.WorkStatus;

public abstract class BaseRepository<OBJ extends SendBirdObject, DAO extends Dao>
        implements SendBirdApi<OBJ> {

    protected DAO dao;

    BaseRepository(DAO dao) {
        this.dao = dao;
    }

    final LiveData<WorkStatus> enqueue(WorkRequest request) {
        SendBirdWorkManager.getInstance().enqueue(request);
        return getWorkStatusById(request.getId());
    }

    final void enqueue(WorkRequest... requests) {
        SendBirdWorkManager.getInstance().enqueue(requests);
    }

    final LiveData<WorkStatus> getWorkStatusById(UUID workId) {
        return SendBirdWorkManager.getInstance().getStatusById(workId);
    }
}
