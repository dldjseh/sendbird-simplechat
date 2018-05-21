package com.android.architecture_components.persistence.dao;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.android.architecture_components.persistence.entity.Channel;

import java.util.List;

@Dao
public interface ChannelDao extends com.android.architecture_components.persistence.dao.Dao {

    @Query("SELECT * FROM channel")
    DataSource.Factory<Integer, Channel> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Channel... channels);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(List<Channel> channels);
}
