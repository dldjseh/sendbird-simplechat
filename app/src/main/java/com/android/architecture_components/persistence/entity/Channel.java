package com.android.architecture_components.persistence.entity;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.google.common.collect.Lists;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.OpenChannel;

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

    public static Channel create(OpenChannel openChannel) {
        return new Channel(openChannel.getUrl(), openChannel.getName());
    }

    public static Channel create(BaseChannel baseChannel) {
        return create((OpenChannel) baseChannel);
    }

    public static List<Channel> create(List<OpenChannel> openChannels) {
        List<Channel> result = Lists.newArrayList();
        for (OpenChannel openChannel : openChannels) {
            result.add(create(openChannel));
        }
        return result;
    }
}
