package com.android.architecture_components.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.repository.MessageRepository;

public class MessageViewModel extends BaseAndroidViewModel<MessageRepository> {

    private MessageViewModel(@NonNull Application application, @NonNull MessageRepository messageRepository) {
        super(application, messageRepository);
    }

    public LiveData<PagedList<Message>> getMessages() {
        return repository.getAll();
    }
}
