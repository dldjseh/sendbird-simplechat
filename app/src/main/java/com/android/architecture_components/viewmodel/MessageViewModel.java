package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.repository.MessageRepository;

public class MessageViewModel extends BaseAndroidViewModel<Message> {

    private LiveData<PagedList<Message>> messages;

    private MessageViewModel(@NonNull Application application, @NonNull MessageRepository messageRepository) {
        super(application);
        messages = messageRepository.getAllLiveData();
    }

    @Nullable
    @Override
    public LiveData<PagedList<Message>> getAllLiveData() {
        return messages;
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
