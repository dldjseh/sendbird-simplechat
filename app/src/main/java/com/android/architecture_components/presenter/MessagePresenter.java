package com.android.architecture_components.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.text.Editable;

import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.ui.MessageRecyclerView;
import com.android.architecture_components.viewmodel.MessageViewModel;

public class MessagePresenter extends Presenter<MessageRecyclerView, MessageViewModel> {

    public MessagePresenter(LifecycleOwner lifecycleOwner, MessageRecyclerView messageView, MessageViewModel messageViewModel) {
        super(lifecycleOwner, messageView, messageViewModel);
    }

    @Override
    protected void observe() {
        androidViewModel.getMessages().observe(lifecycleOwner, new Observer<PagedList<Message>>() {
            @Override
            public void onChanged(@Nullable PagedList<Message> messages) {
                view.submitList(messages);
            }
        });
    }

    public void onSendClicked(Editable editable) {
        view.sendMessage(Message.create());
    }
}
