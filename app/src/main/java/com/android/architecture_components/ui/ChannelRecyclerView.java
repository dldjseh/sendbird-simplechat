package com.android.architecture_components.ui;

import com.android.architecture_components.persistence.entity.Channel;

public interface ChannelRecyclerView extends BaseRecyclerView<Channel> {

    void displayLoggedInSnackbar();
}
