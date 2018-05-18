package com.android.architecture_components.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.architecture_components.R;
import com.android.architecture_components.internal.ChatDatabase;
import com.android.architecture_components.internal.dao.MessageDao;
import com.android.architecture_components.internal.entity.Message;
import com.android.architecture_components.presenter.MessagePresenter;
import com.android.architecture_components.repository.MessageRepository;
import com.android.architecture_components.ui.adapter.MessageAdapter;
import com.android.architecture_components.ui.adapter.MessageItemCallback;
import com.android.architecture_components.viewmodel.MessageViewModel;

import butterknife.BindView;

public class MessageActivity extends BaseActivity implements MessageView {

    private MessagePresenter messagePresenter;

    private MessageAdapter messageAdapter;

    @BindView(R.id.activity_message_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        MessageDao messageDao = ChatDatabase.getInstance(this).getMessageDao();
        MessageRepository messageRepository = new MessageRepository(messageDao);

        MessageViewModel.Factory factory = new MessageViewModel.Factory(getApplication(), messageRepository);
        MessageViewModel messageViewModel = ViewModelProviders.of(this, factory).get(MessageViewModel.class);

        messagePresenter = new MessagePresenter(this, this, messageViewModel);
        messagePresenter.init();

        MessageItemCallback messageItemCallback = new MessageItemCallback();
        messageAdapter = new MessageAdapter(messageItemCallback);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(messageAdapter);
    }

    @Override
    public void submitList(@Nullable PagedList<Message> list) {
        messageAdapter.submitList(list);
    }
}
