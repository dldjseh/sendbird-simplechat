package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;

import com.android.architecture_components.persistence.dao.UserDao;
import com.android.architecture_components.persistence.entity.User;
import com.android.architecture_components.work.ConnectWorker;

import androidx.work.WorkStatus;

public class UserRepository extends Repository<UserDao, User> {

    public UserRepository(UserDao userDao) {
        super(userDao);
    }

    @Override
    public LiveData<User> getFirst() {
        return dao.getFirst();
    }

    public LiveData<WorkStatus> connect() {
        return enqueue(new ConnectWorker.Builder<ConnectWorker>().build(ConnectWorker.class));
    }
}
