package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.repository.ChannelRepository;

public class ChannelViewModel extends BaseAndroidViewModel<Channel> {

    private LiveData<PagedList<Channel>> channels;

    private ChannelViewModel(@NonNull Application application, @NonNull ChannelRepository channelRepository) {
        super(application);
        channels = channelRepository.getAllLiveData();
    }

    @Nullable
    @Override
    public LiveData<PagedList<Channel>> getAllLiveData() {
        return channels;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private Application application;

        @NonNull
        private ChannelRepository repository;

        public Factory(@NonNull Application application, @NonNull ChannelRepository repository) {
            this.application = application;
            this.repository = repository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ChannelViewModel(application, repository);
        }
    }
}
