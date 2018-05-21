package com.android.architecture_components.ui.adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.architecture_components.R;
import com.android.architecture_components.persistence.entity.Channel;

import butterknife.BindView;

public class ChannelAdapter extends PagedListAdapter<Channel, ChannelAdapter.ChannelViewHolder> {

    public ChannelAdapter(@NonNull DiffUtil.ItemCallback<Channel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_channel, parent, false);
        return new ChannelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelViewHolder holder, int position) {
        Channel channel = getItem(position);

        if (channel == null) {
            holder.text.setText("null");
        } else {
            holder.text.setText(channel.getName());
        }
    }

    class ChannelViewHolder extends ViewHolder {

        @BindView(R.id.view_holder_channel_text)
        TextView text;

        ChannelViewHolder(View itemView) {
            super(itemView);
        }
    }
}
