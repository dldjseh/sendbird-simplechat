package com.android.architecture_components.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

import com.android.architecture_components.persistence.dao.UserDao;
import com.android.architecture_components.persistence.entity.User;
import com.android.architecture_components.worker.ConnectWorker;
import com.android.architecture_components.worker.DisconnectWorker;

import androidx.work.WorkStatus;

public class UserRepository extends BaseRepository<User, UserDao> {

    public UserRepository(UserDao dao) {
        super(dao);
    }

    @Override
    public LiveData<PagedList<User>> getAllLiveData() {
        return null;
    }

    @Override
    public LiveData<User> getFirstLiveData() {
        return dao.getFirst();
    }

    public LiveData<WorkStatus> connect() {
        return enqueue(new ConnectWorker.Builder<ConnectWorker>().build(ConnectWorker.class));
    }

    public LiveData<WorkStatus> disconnect() {
        return enqueue(new DisconnectWorker.Builder<DisconnectWorker>().build(DisconnectWorker.class));
    }
}
