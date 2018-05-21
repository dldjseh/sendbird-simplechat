package com.android.architecture_components.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.android.architecture_components.persistence.dao.ChannelDao;
import com.android.architecture_components.persistence.dao.MessageDao;
import com.android.architecture_components.persistence.dao.UserDao;
import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.persistence.entity.User;

@Database(entities = {Message.class, User.class, Channel.class}, version = 1)
public abstract class ChatDatabase extends RoomDatabase {

    private static final String DB_NAME = "repoDatabase.db";
    private static volatile ChatDatabase instance;

    public static synchronized ChatDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static ChatDatabase create(final Context context) {
        return Room.databaseBuilder(context, ChatDatabase.class, DB_NAME).build();
    }

    public abstract MessageDao getMessageDao();

    public abstract ChannelDao getChannelDao();

    public abstract UserDao getUserDao();
}
