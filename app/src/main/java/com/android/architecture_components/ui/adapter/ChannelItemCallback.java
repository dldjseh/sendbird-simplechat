package com.android.architecture_components.ui.adapter;

import android.support.v7.util.DiffUtil;

import com.android.architecture_components.persistence.entity.Channel;
import com.google.common.base.Objects;

public class ChannelItemCallback extends DiffUtil.ItemCallback<Channel> {

    @Override
    public boolean areItemsTheSame(Channel oldItem, Channel newItem) {
        return Objects.equal(oldItem.getId(), newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(Channel oldItem, Channel newItem) {
        return Objects.equal(oldItem.getId(), newItem.getId());
    }
}
