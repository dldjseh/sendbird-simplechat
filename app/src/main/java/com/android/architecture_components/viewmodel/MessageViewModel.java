package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.repository.MessageRepository;

public class MessageViewModel extends BaseAndroidViewModel<MessageRepository> {

    private LiveData<PagedList<Message>> messages;

    private MessageViewModel(@NonNull Application application, @NonNull MessageRepository messageRepository) {
        super(application, messageRepository);
        messages = messageRepository.getAll();
    }

    public LiveData<PagedList<Message>> getMessages() {
        return messages;
    }

    public void save(Message message) {

    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private Application application;

        @NonNull
        private MessageRepository repository;

        public Factory(@NonNull Application application) {
            this.application = application;
            this.repository = new MessageRepository(ChatDatabase.getInstance(application).getMessageDao());
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MessageViewModel(application, repository);
        }
    }
}
