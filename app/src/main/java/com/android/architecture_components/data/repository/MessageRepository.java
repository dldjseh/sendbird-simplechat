package com.android.architecture_components.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.android.architecture_components.data.event.MessageLiveEvent;
import com.android.architecture_components.persistence.dao.MessageDao;
import com.android.architecture_components.persistence.entity.Message;

public class MessageRepository extends BaseRepository<Message, MessageDao, MessageLiveEvent> {

    public MessageRepository(MessageDao dao) {
        super(dao);
    }

    @Override
    public LiveData<PagedList<Message>> getAllLiveData() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .setEnablePlaceholders(true)
                .build();

        return new LivePagedListBuilder<>(dao.getAll(), config).build();
    }

    @Override
    public LiveData<Message> getFirstLiveData() {
        return null;
    }

    @Override
    public MessageLiveEvent getLiveEvent() {
        return MessageLiveEvent.create();
    }
}
