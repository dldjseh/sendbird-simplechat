package com.android.architecture_components.persistence.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.android.architecture_components.persistence.entity.User;

@Dao
public interface UserDao extends com.android.architecture_components.persistence.dao.Dao {

    @Query("SELECT * FROM user LIMIT 1")
    LiveData<User> getFirst();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(User user);
}
