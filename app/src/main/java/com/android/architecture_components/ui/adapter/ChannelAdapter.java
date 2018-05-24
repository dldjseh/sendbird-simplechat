package com.android.architecture_components.ui.adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.ui.intent.MessageListIntent;

import butterknife.BindView;

public class ChannelAdapter extends PagedListAdapter<Channel, ChannelAdapter.ChannelViewHolder> {

    public ChannelAdapter(@NonNull DiffUtil.ItemCallback<Channel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final Context context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);


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

        final Context context = holder.text.getContext();
        final String channelId = channel.getId();

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new MessageListIntent(context, channelId));
            }
        });
    }

    class ChannelViewHolder extends ViewHolder {

        @BindView(android.R.id.text1)
        TextView text;

        ChannelViewHolder(View itemView) {
            super(itemView);
        }
    }
}
