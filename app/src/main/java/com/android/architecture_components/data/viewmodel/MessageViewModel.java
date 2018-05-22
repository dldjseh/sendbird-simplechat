package com.android.architecture_components.data.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.android.architecture_components.data.repository.MessageRepository;
import com.android.architecture_components.persistence.entity.Message;

public class MessageViewModel extends SendBirdViewModel<Message> {

    private LiveData<PagedList<Message>> messages;

    private MessageViewModel(@NonNull Application application, @NonNull MessageRepository messageRepository) {
        super(application);
        messages = messageRepository.getAllLiveData();
    }

    @Override
    public LiveData<PagedList<Message>> getAllLiveData() {
        return messages;
    }

    @Override
    public LiveData<Message> getFirstLiveData() {
        return null;
    }

    public void save(Message message) {

    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private Application application;

        @NonNull
        private MessageRepository repository;

        public Factory(@NonNull Application application, @NonNull MessageRepository repository) {
            this.application = application;
            this.repository = repository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MessageViewModel(application, repository);
        }
    }
}
