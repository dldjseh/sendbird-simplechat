package com.android.architecture_components.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.android.architecture_components.R;
import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.presenter.ChannelPresenter;
import com.android.architecture_components.viewmodel.ChannelViewModel;

import butterknife.BindView;
import butterknife.OnClick;

public class ChannelActivity extends BaseActivity implements ChannelRecyclerView {

    @BindView(R.id.activity_channel_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.activity_channel_edit_text)
    EditText editText;

    private ChannelPresenter channelPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        ChannelViewModel.Factory factory = new ChannelViewModel.Factory(getApplication());
        ChannelViewModel channelViewModel = ViewModelProviders.of(this, factory).get(ChannelViewModel.class);

        channelPresenter = new ChannelPresenter(this, this, channelViewModel);
    }

    @Override
    public void displayLoggedInSnackbar() {
        Snackbar.make(recyclerView, "Logged In", Snackbar.LENGTH_LONG).show();
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
