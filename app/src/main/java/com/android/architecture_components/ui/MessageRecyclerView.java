package com.android.architecture_components.ui;

import com.android.architecture_components.persistence.entity.Message;

public interface MessageRecyclerView extends BaseRecyclerView<Message> {

    void sendMessage(Message message);
}
