package com.android.architecture_components.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.content.Context;

import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.dao.ChannelDao;
import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.work.CreateChannelWorker;
import com.android.architecture_components.work.GetAllChannelsWorker;

import androidx.work.WorkStatus;

public class ChannelRepository extends SendBirdRepository<Channel, ChannelDao> {

    public ChannelRepository(Context context) {
        super(ChatDatabase.getInstance(context).getChannelDao());
    }

    @Override
    public LiveData<PagedList<Channel>> getAllLiveData() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .setEnablePlaceholders(true)
                .build();

        return new LivePagedListBuilder<>(dao.getAll(), config).build();
    }

    @Override
    public LiveData<Channel> getFirstLiveData() {
        return null;
    }

    public LiveData<WorkStatus> getAllNetworkData() {
        return enqueue(new GetAllChannelsWorker.Builder<GetAllChannelsWorker>()
                .build(GetAllChannelsWorker.class));
    }

    public LiveData<WorkStatus> create(String channelName) {
        return enqueue(new CreateChannelWorker.Builder<CreateChannelWorker>()
                .putData(CreateChannelWorker.CHANNEL_NAME, channelName)
                .build(CreateChannelWorker.class));
    }
}
