package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.dao.ChannelDao;
import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.worker.CreateChannelWorker;
import com.android.architecture_components.worker.GetAllChannelsWorker;

import androidx.work.WorkStatus;

public class ChannelListRepository extends BaseRepository<Channel, ChannelDao> {

    public ChannelListRepository(ChannelDao dao) {
        super(dao);
    }

    @Override
    public LiveData<PagedList<Channel>> getAllLiveData(@Nullable String id) {
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
                .putString(CreateChannelWorker.CHANNEL_NAME, channelName)
                .build(CreateChannelWorker.class));
    }
}
