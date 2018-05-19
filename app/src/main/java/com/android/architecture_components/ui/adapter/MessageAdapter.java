package com.android.architecture_components.ui.adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.architecture_components.R;
import com.android.architecture_components.persistence.entity.Message;

import butterknife.BindView;

public class MessageAdapter extends PagedListAdapter<Message, MessageAdapter.MessageViewHolder> {

    public MessageAdapter(@NonNull DiffUtil.ItemCallback<Message> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = getItem(position);

        if (message == null) {
            holder.text.setText("null");
        } else {
            holder.text.setText(message.getId());
        }
    }

    class MessageViewHolder extends ViewHolder {

        @BindView(R.id.view_holder_message_text)
        TextView text;

        MessageViewHolder(View itemView) {
            super(itemView);
        }
    }
}
