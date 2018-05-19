package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.entity.User;
import com.android.architecture_components.repository.UserRepository;

public class UserViewModel extends BaseAndroidViewModel<UserRepository> {

    private LiveData<com.android.architecture_components.persistence.entity.User> user;

    private UserViewModel(@NonNull Application application, @NonNull UserRepository userRepository) {
        super(application, userRepository);
    }

    @Override
    protected void init(UserRepository repository) {
        user = repository.getFirst();
    }

    public LiveData<User> getUser() {
        return user;
    }
}
