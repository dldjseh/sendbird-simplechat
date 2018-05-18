package com.android.architecture_components.ui;

import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.android.architecture_components.R;
import com.android.architecture_components.internal.entity.Channel;
import com.android.architecture_components.internal.entity.Message;

import butterknife.BindView;
import butterknife.OnClick;

public class ChannelActivity extends BaseActivity implements ChannelView {

    @BindView(R.id.activity_channel_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.activity_channel_edit_text)
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
    }

    @Override
    public void createChannel(Channel channel) {

    }

    @Override
    public void joinChannel(String channelId) {

    }

    @Override
    public void submitList(@Nullable PagedList<Message> list) {

    }

    @OnClick(R.id.activity_channel_create_button)
    protected void onCreateClicked() {

    }
}
