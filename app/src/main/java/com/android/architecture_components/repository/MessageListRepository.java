package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.dao.MessageDao;
import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.worker.EnterChannelWorker;
import com.android.architecture_components.worker.LoadMessagesWorker;
import com.android.architecture_components.worker.SendMessageWorker;

import androidx.work.WorkStatus;

public class MessageListRepository extends BaseRepository<Message, MessageDao> {

    public MessageListRepository(MessageDao dao) {
        super(dao);
    }

    @Override
    public LiveData<PagedList<Message>> getAllLiveData(@Nullable String id) {
        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .setEnablePlaceholders(true)
                .build();

        return new LivePagedListBuilder<>(dao.getAll(id), config).build();
    }

    @Override
    public LiveData<Message> getFirstLiveData() {
        return null;
    }

    public void enterChannelAndLoadMessages(String channelId) {
        enqueue(new EnterChannelWorker.Builder<EnterChannelWorker>()
                        .putString(EnterChannelWorker.CHANNEL_ID_KEY, channelId)
                        .build(EnterChannelWorker.class),
                new LoadMessagesWorker.Builder<LoadMessagesWorker>()
                        .putString(LoadMessagesWorker.CHANNEL_ID_KEY, channelId)
                        .build(LoadMessagesWorker.class));
    }

    public LiveData<WorkStatus> send(String channelId, String message) {
        return enqueue(new SendMessageWorker.Builder<SendMessageWorker>()
                .putString(SendMessageWorker.CHANNEL_ID_KEY, channelId)
                .putString(SendMessageWorker.MESSAGE_KEY, message)
                .build(SendMessageWorker.class));
    }
}
