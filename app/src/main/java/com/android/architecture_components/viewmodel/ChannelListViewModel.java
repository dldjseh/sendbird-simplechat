package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.android.architecture_components.repository.ChannelListRepository;
import com.android.architecture_components.persistence.entity.Channel;

public class ChannelListViewModel extends BaseViewModel<Channel, ChannelListRepository> {

    private LiveData<PagedList<Channel>> channels;

    private ChannelListViewModel(@NonNull Application application, @NonNull ChannelListRepository channelRepository) {
        super(application, channelRepository);
    }

    @Override
    public LiveData<PagedList<Channel>> getAllLiveData() {
        if (channels == null) {
            channels = repository.getAllLiveData();
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
