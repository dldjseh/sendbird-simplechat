package com.android.architecture_components.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.text.Editable;

import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.repository.MessageListRepository;
import com.android.architecture_components.ui.MessageRecyclerView;
import com.android.architecture_components.ui.intent.MessageListIntent;
import com.android.architecture_components.viewmodel.MessageListViewModel;

public class MessageListPresenter extends BasePresenter<MessageRecyclerView, MessageListRepository, MessageListViewModel> {

    private String channelId;

    public MessageListPresenter(LifecycleOwner lifecycleOwner, MessageRecyclerView view, MessageListRepository repository, MessageListViewModel viewModel) {
        super(lifecycleOwner, view, repository, viewModel);
        repository.enterChannelAndLoadMessages(getChannelId());
    }

    @Override
    protected void observeLiveData() {
        androidViewModel.getAllLiveData(getChannelId()).observe(lifecycleOwner, new Observer<PagedList<Message>>() {
            @Override
            public void onChanged(@Nullable PagedList<Message> messages) {
                view.submitList(messages);
            }
        });
    }

    private String getChannelId() {
        if (channelId == null) {
            channelId = MessageListIntent.getChannelId(view.getIntent());
        }
        return channelId;
    }

    public void onSendClicked(Editable editable) {
        repository.send(getChannelId(), editable.toString());
    }
}
