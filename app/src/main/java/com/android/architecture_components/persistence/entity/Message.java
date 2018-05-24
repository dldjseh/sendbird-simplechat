package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

import com.google.common.collect.Lists;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.UserMessage;

import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(foreignKeys = @ForeignKey(entity = Channel.class,
        parentColumns = "id",
        childColumns = "channelId",
        onDelete = CASCADE))
public class Message extends SendBirdObject {

    private String channelId;
    private String message;

    public Message(@NonNull String id, @NonNull String channelId, @NonNull String message) {
        super(id);
        this.channelId = channelId;
        this.message = message;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Message create(UserMessage userMessage) {
        return new Message(String.valueOf(userMessage.getMessageId()),
                userMessage.getChannelUrl(),
                userMessage.getMessage());
    }

    public static List<Message> create(List<BaseMessage> baseMessages) {
        List<Message> result = Lists.newArrayList();
        for (BaseMessage baseMessage : baseMessages) {
            result.add(create((UserMessage) baseMessage));
        }
        return result;
    }
}
