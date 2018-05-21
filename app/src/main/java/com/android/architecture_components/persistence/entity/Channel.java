package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.google.common.collect.Lists;
import com.sendbird.android.GroupChannel;

import java.util.List;

@Entity
public class Channel extends SendBirdObject {

    private String name;

    public Channel(@NonNull String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Channel create(GroupChannel groupChannel) {
        return new Channel(groupChannel.getUrl(), groupChannel.getName());
    }

    public static List<Channel> create(List<GroupChannel> groupChannels) {
        List<Channel> result = Lists.newArrayList();
        for (GroupChannel groupChannel : groupChannels) {
            result.add(create(groupChannel));
        }
        return result;
    }
}
