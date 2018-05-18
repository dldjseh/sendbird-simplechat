package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.android.architecture_components.internal.dao.MessageDao;
import com.android.architecture_components.internal.entity.Message;

public class MessageRepository extends Repository<MessageDao> {

    public MessageRepository(MessageDao messageDao) {
        super(messageDao);
    }

    @Override
    public LiveData<PagedList<Message>> getAll() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .setEnablePlaceholders(true)
                .build();

        return new LivePagedListBuilder<>(dao.getAll(), config).build();
    }
}
