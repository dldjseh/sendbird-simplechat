package com.android.architecture_components.ui.adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.architecture_components.persistence.entity.Message;

import butterknife.BindView;

public class MessageAdapter extends PagedListAdapter<Message, MessageAdapter.MessageViewHolder> {

    public MessageAdapter(@NonNull DiffUtil.ItemCallback<Message> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = getItem(position);

        if (message == null) {
            holder.text.setText("null");
        } else {
            holder.text.setText(message.getMessage());
        }
    }

    class MessageViewHolder extends ViewHolder {

        @BindView(android.R.id.text1)
        TextView text;

        MessageViewHolder(View itemView) {
            super(itemView);
        }
    }
}
