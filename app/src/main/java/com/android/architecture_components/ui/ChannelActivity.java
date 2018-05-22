package com.android.architecture_components.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.android.architecture_components.R;
import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.presenter.ChannelPresenter;
import com.android.architecture_components.data.repository.ChannelRepository;
import com.android.architecture_components.ui.adapter.ChannelAdapter;
import com.android.architecture_components.ui.adapter.ChannelItemCallback;
import com.android.architecture_components.data.viewmodel.ChannelViewModel;

import butterknife.BindView;
import butterknife.OnClick;

public class ChannelActivity extends BaseActivity implements ChannelRecyclerView {

    @BindView(R.id.activity_channel_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.activity_channel_edit_text)
    EditText editText;

    private ChannelPresenter channelPresenter;

    private ChannelAdapter channelAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        ChannelRepository repository = new ChannelRepository(this);
        ChannelViewModel.Factory factory = new ChannelViewModel.Factory(getApplication(), repository);
        ChannelViewModel viewModel = ViewModelProviders.of(this, factory).get(ChannelViewModel.class);

        channelPresenter = new ChannelPresenter(this, this, repository, viewModel);

        channelAdapter = new ChannelAdapter(new ChannelItemCallback());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(channelAdapter);
    }

    @Override
    public void displayLoggedInSnackbar() {
        Snackbar.make(recyclerView, "Logged In", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void submitList(@Nullable PagedList<Channel> list) {
        channelAdapter.submitList(list);
    }

    @OnClick(R.id.activity_channel_create_button)
    protected void onCreateChannelClicked() {
        channelPresenter.onCreateChannelClicked(editText.getText());
    }
}
