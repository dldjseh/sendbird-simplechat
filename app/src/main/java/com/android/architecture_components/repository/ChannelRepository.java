package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.android.architecture_components.persistence.dao.ChannelDao;
import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.work.CreateGroupChannelWorker;
import com.android.architecture_components.work.GetAllGroupChannelsWorker;

import androidx.work.WorkStatus;

public class ChannelRepository extends Repository<ChannelDao, Channel> {

    public ChannelRepository(ChannelDao channelDao) {
        super(channelDao);
    }

    @Override
    public LiveData<PagedList<Channel>> getAll() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .setEnablePlaceholders(true)
                .build();

        return new LivePagedListBuilder<>(dao.getAll(), config).build();
    }

    public LiveData<WorkStatus> getAllFromNetwork() {
        return enqueue(new GetAllGroupChannelsWorker.Builder<GetAllGroupChannelsWorker>()
                .build(GetAllGroupChannelsWorker.class));
    }

    public LiveData<WorkStatus> create(String channelName) {
        return enqueue(new CreateGroupChannelWorker.Builder<CreateGroupChannelWorker>()
                .putData(CreateGroupChannelWorker.CHANNEL_NAME, channelName)
                .build(CreateGroupChannelWorker.class));
    }
}
