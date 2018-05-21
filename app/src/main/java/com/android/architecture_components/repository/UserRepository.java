package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;

import com.android.architecture_components.persistence.dao.UserDao;
import com.android.architecture_components.persistence.entity.User;
import com.android.architecture_components.work.sendbird.ConnectWorker;

import androidx.work.WorkStatus;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
        Observable.just(user)
                .doOnNext(new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        dao.save(user);
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public LiveData<WorkStatus> connect() {
        return enqueue(new ConnectWorker.Builder<ConnectWorker>().build(ConnectWorker.class));
    }
}
