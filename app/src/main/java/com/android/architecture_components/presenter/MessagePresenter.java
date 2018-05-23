package com.android.architecture_components.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.text.Editable;

import com.android.architecture_components.data.repository.MessageRepository;
import com.android.architecture_components.data.viewmodel.MessageViewModel;
import com.android.architecture_components.persistence.dao.MessageDao;
import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.ui.MessageRecyclerView;

public class MessagePresenter extends BasePresenter<MessageRecyclerView, MessageDao, MessageRepository, MessageViewModel> {

    public MessagePresenter(LifecycleOwner lifecycleOwner, MessageRecyclerView view, MessageDao dao, MessageRepository repository, MessageViewModel viewModel) {
        super(lifecycleOwner, view, dao, repository, viewModel);
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

    @Override
    protected void registerChannelEvent() {

    }

    public void onSendClicked(Editable editable) {
        androidViewModel.save(new Message(""));
    }
}
