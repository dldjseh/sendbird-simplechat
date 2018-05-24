package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.dao.UserDao;
import com.android.architecture_components.persistence.entity.User;
import com.android.architecture_components.worker.ConnectWorker;

import androidx.work.WorkStatus;

public class AuthRepository extends BaseRepository<User, UserDao> {

    public AuthRepository(UserDao dao) {
        super(dao);
    }

    @Override
    public LiveData<PagedList<User>> getAllLiveData(@Nullable String id) {
        return null;
    }

    @Override
    public LiveData<User> getFirstLiveData() {
        return dao.getFirst();
    }

    public LiveData<WorkStatus> connect() {
        return enqueue(new ConnectWorker.Builder<ConnectWorker>().build(ConnectWorker.class));
    }
}
