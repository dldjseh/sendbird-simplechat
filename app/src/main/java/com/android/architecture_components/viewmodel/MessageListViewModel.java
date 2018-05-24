package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.android.architecture_components.repository.MessageListRepository;
import com.android.architecture_components.persistence.entity.Message;

public class MessageListViewModel extends BaseViewModel<Message, MessageListRepository> {

    private LiveData<PagedList<Message>> messages;

    private MessageListViewModel(@NonNull Application application, @NonNull MessageListRepository messageRepository) {
        super(application, messageRepository);
    }

    @Override
    public LiveData<PagedList<Message>> getAllLiveData() {
        if (messages == null) {
            messages = repository.getAllLiveData();
        }
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
        private MessageListRepository repository;

        public Factory(@NonNull Application application, @NonNull MessageListRepository repository) {
            this.application = application;
            this.repository = repository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MessageListViewModel(application, repository);
        }
    }
}
