package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.android.architecture_components.internal.entity.Message;
import com.android.architecture_components.repository.MessageRepository;

public class MessageViewModel extends AndroidViewModel {

    private MessageViewModel(@NonNull Application application, @NonNull MessageRepository messageRepository) {
        super(application);
        messages = messageRepository.getAll();
    }

    private LiveData<PagedList<Message>> messages;

    public LiveData<PagedList<Message>> getMessages() {
        return messages;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private Application application;

        @NonNull
        private MessageRepository messageRepository;

        public Factory(@NonNull Application application, @NonNull MessageRepository messageRepository) {
            this.application = application;
            this.messageRepository = messageRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MessageViewModel(application, messageRepository);
        }
    }
}
