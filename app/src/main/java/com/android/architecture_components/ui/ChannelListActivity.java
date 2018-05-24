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
import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.dao.ChannelDao;
import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.presenter.ChannelListPresenter;
import com.android.architecture_components.repository.ChannelListRepository;
import com.android.architecture_components.ui.adapter.ChannelAdapter;
import com.android.architecture_components.ui.adapter.ChannelItemCallback;
import com.android.architecture_components.viewmodel.ChannelListViewModel;

import butterknife.BindView;
import butterknife.OnClick;

public class ChannelListActivity extends BaseActivity implements ChannelRecyclerView {

    @BindView(R.id.activity_channel_list_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.activity_channel_list_edit_text)
    EditText editText;

    private ChannelListPresenter channelPresenter;

    private ChannelAdapter channelAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_list);

        ChannelDao dao = ChatDatabase.getInstance(this).getChannelDao();
        ChannelListRepository repository = new ChannelListRepository(dao);

        ChannelListViewModel.Factory factory = new ChannelListViewModel.Factory(getApplication(), repository);
        ChannelListViewModel viewModel = ViewModelProviders.of(this, factory).get(ChannelListViewModel.class);

        channelPresenter = new ChannelListPresenter(this, this, repository, viewModel);

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

    @OnClick(R.id.activity_channel_list_create_button)
    protected void onCreateChannelClicked() {
        channelPresenter.onCreateChannelClicked(editText.getText());
    }
}
