package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.android.architecture_components.repository.Repository;

public class BaseAndroidViewModel<REPO extends Repository> extends AndroidViewModel {

    protected REPO repository;

    protected BaseAndroidViewModel(@NonNull Application application, @NonNull REPO repository) {
        super(application);
        this.repository = repository;
    }

    public static class Factory<REPO extends Repository> extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private Application application;

        @NonNull
        private REPO repository;

        public Factory(@NonNull Application application, @NonNull REPO repository) {
            this.application = application;
            this.repository = repository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new BaseAndroidViewModel(application, repository);
        }
    }
}
