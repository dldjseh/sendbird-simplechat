package com.android.architecture_components.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.android.architecture_components.data.repository.ChannelRepository;
import com.android.architecture_components.persistence.entity.Channel;

public class ChannelViewModel extends BaseViewModel<Channel, ChannelRepository> {

    private LiveData<PagedList<Channel>> channels;

    private ChannelViewModel(@NonNull Application application, @NonNull ChannelRepository channelRepository) {
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
