package com.android.architecture_components.repository;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.android.architecture_components.persistence.dao.ChannelDao;
import com.android.architecture_components.persistence.entity.Channel;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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

    @Override
    public void save(Channel channel) {
        Observable.just(channel)
                .doOnNext(new Consumer<Channel>() {
                    @Override
                    public void accept(Channel channel) {
                        dao.save(channel);
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}
