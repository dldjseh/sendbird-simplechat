package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.android.architecture_components.repository.AuthRepository;
import com.android.architecture_components.persistence.entity.User;

public class AuthViewModel extends BaseViewModel<User, AuthRepository> {

    private LiveData<User> user;

    private AuthViewModel(@NonNull Application application, @NonNull AuthRepository userRepository) {
        super(application, userRepository);
    }

    @Override
    public LiveData<PagedList<User>> getAllLiveData() {
        return null;
    }

    @Override
    public LiveData<User> getFirstLiveData() {
        if (user == null) {
            user = repository.getFirstLiveData();
        }
        return user;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private Application application;

        @NonNull
        private AuthRepository repository;

        public Factory(@NonNull Application application, @NonNull AuthRepository repository) {
            this.application = application;
            this.repository = repository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new AuthViewModel(application, repository);
        }
    }
}
