package com.android.architecture_components.presenter;

import android.arch.lifecycle.LifecycleOwner;

import com.android.architecture_components.ui.ChannelRecyclerView;
import com.android.architecture_components.viewmodel.ChannelViewModel;

public class ChannelPresenter extends Presenter<ChannelRecyclerView, ChannelViewModel> {

    public ChannelPresenter(LifecycleOwner lifecycleOwner, ChannelRecyclerView channelRecyclerView, ChannelViewModel channelViewModel) {
        super(lifecycleOwner, channelRecyclerView, channelViewModel);
    }

    @Override
    protected void observe() {

    }

    @Override
    protected void initUI() {
        view.displayLoggedInSnackbar();
    }
}
