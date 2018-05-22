package com.android.architecture_components.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.text.Editable;

import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.repository.MessageRepository;
import com.android.architecture_components.ui.MessageRecyclerView;
import com.android.architecture_components.viewmodel.MessageViewModel;

public class MessagePresenter extends Presenter<MessageRecyclerView, MessageRepository, MessageViewModel> {

    public MessagePresenter(LifecycleOwner lifecycleOwner, MessageRecyclerView view, MessageRepository repository, MessageViewModel viewModel) {
        super(lifecycleOwner, view, repository, viewModel);
    }

    @Override
    protected void init() {
        androidViewModel.getAllLiveData().observe(lifecycleOwner, new Observer<PagedList<Message>>() {
            @Override
            public void onChanged(@Nullable PagedList<Message> messages) {
                view.submitList(messages);
            }
        });
    }

    public void onSendClicked(Editable editable) {
        androidViewModel.save(new Message(""));
    }
}
