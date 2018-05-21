package com.android.architecture_components.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.text.Editable;

import com.android.architecture_components.persistence.entity.Channel;
import com.android.architecture_components.ui.ChannelRecyclerView;
import com.android.architecture_components.viewmodel.ChannelViewModel;

public class ChannelPresenter extends Presenter<ChannelRecyclerView, ChannelViewModel> {

    public ChannelPresenter(LifecycleOwner lifecycleOwner, ChannelRecyclerView channelRecyclerView, ChannelViewModel channelViewModel) {
        super(lifecycleOwner, channelRecyclerView, channelViewModel);
    }

    @Override
    protected void observe() {
        androidViewModel.getChannels().observe(lifecycleOwner, new Observer<PagedList<Channel>>() {
            @Override
            public void onChanged(@Nullable PagedList<Channel> channels) {
                view.submitList(channels);
            }
        });
    }

    @Override
    protected void initUI() {
        view.displayLoggedInSnackbar();
    }


    public void onCreateChannelClicked(Editable editable) {
        androidViewModel.create(editable.toString());
    }

    public void onJoinChannelClicked() {

    }
}
