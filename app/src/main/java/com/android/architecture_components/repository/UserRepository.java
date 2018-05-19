package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;

import com.android.architecture_components.persistence.dao.UserDao;
import com.android.architecture_components.persistence.entity.User;

public class UserRepository extends Repository<UserDao, User> {

    public UserRepository(UserDao userDao) {
        super(userDao);
    }

    @Override
    public LiveData<User> getFirst() {
        return dao.getFirst();
    }

    @Override
    public void save(User user) {
        super.save(user);
    }
}
