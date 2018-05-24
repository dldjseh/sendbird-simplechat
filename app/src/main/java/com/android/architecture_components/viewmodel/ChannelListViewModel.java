package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.repository.ChannelListRepository;

public class ChannelListViewModel extends BaseViewModel<Channel, ChannelListRepository> {

    private LiveData<PagedList<Channel>> channels;

    private ChannelListViewModel(@NonNull Application application, @NonNull ChannelListRepository channelRepository) {
        super(application, channelRepository);
    }

    @Override
    public LiveData<PagedList<Channel>> getAllLiveData(@Nullable String id) {
        if (channels == null) {
            channels = repository.getAllLiveData(id);
        }
        return channels;
    }

    @Override
    public LiveData<Channel> getFirstLiveData() {
        return null;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private Application application;

        @NonNull
        private ChannelListRepository repository;

        public Factory(@NonNull Application application, @NonNull ChannelListRepository repository) {
            this.application = application;
            this.repository = repository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ChannelListViewModel(application, repository);
        }
    }
}
