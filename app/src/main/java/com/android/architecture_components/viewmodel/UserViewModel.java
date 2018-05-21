package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.entity.User;
import com.android.architecture_components.repository.UserRepository;

public class UserViewModel extends BaseAndroidViewModel<UserRepository> {

    private LiveData<User> user;

    private UserViewModel(@NonNull Application application, @NonNull UserRepository userRepository) {
        super(application, userRepository);
        user = userRepository.getFirst();
    }

    public LiveData<User> getUser() {
        return user;
    }

    public void connect() {
        repository.connect();
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private Application application;

        @NonNull
        private UserRepository repository;

        public Factory(@NonNull Application application) {
            this.application = application;
            this.repository = new UserRepository(ChatDatabase.getInstance(application).getUserDao());
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new UserViewModel(application, repository);
        }
    }
}
