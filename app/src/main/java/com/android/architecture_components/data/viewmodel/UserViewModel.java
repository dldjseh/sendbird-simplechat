package com.android.architecture_components.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.android.architecture_components.data.repository.UserRepository;
import com.android.architecture_components.persistence.entity.User;

public class UserViewModel extends BaseViewModel<User> {

    private LiveData<User> user;

    private UserViewModel(@NonNull Application application, @NonNull UserRepository userRepository) {
        super(application);
        user = userRepository.getFirstLiveData();
    }

    @Override
    public LiveData<PagedList<User>> getAllLiveData() {
        return null;
    }

    @Override
    public LiveData<User> getFirstLiveData() {
        return user;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private Application application;

        @NonNull
        private UserRepository repository;

        public Factory(@NonNull Application application, @NonNull UserRepository repository) {
            this.application = application;
            this.repository = repository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new UserViewModel(application, repository);
        }
    }
}
