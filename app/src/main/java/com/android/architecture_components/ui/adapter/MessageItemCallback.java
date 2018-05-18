package com.android.architecture_components.ui.adapter;

import android.support.v7.util.DiffUtil;

import com.android.architecture_components.internal.entity.Message;
import com.google.common.base.Objects;

public class MessageItemCallback extends DiffUtil.ItemCallback<Message> {

    @Override
    public boolean areItemsTheSame(Message oldItem, Message newItem) {
        return Objects.equal(oldItem.get().getMessageId(), newItem.get().getMessageId());
    }

    @Override
    public boolean areContentsTheSame(Message oldItem, Message newItem) {
        return oldItem.get().getCreatedAt() == newItem.get().getCreatedAt();
    }
}
