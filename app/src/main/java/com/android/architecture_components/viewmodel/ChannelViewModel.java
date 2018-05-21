package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.repository.ChannelRepository;

import androidx.work.WorkStatus;

public class ChannelViewModel extends BaseAndroidViewModel<ChannelRepository> {

    private LiveData<PagedList<Channel>> channels;

    private ChannelViewModel(@NonNull Application application, @NonNull ChannelRepository channelRepository) {
        super(application, channelRepository);
        channels = channelRepository.getAll();
    }

    public LiveData<PagedList<Channel>> getChannels() {
        return channels;
    }

    public LiveData<WorkStatus> getChannelsFromNetwork() {
        return repository.getAllFromNetwork();
    }

    public void create(String channelName) {
        repository.create(channelName);
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private Application application;

        @NonNull
        private ChannelRepository repository;

        public Factory(@NonNull Application application) {
            this.application = application;
            this.repository = new ChannelRepository(ChatDatabase.getInstance(application).getChannelDao());
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ChannelViewModel(application, repository);
        }
    }
}
