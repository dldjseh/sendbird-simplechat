package com.android.architecture_components.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.android.architecture_components.R;
import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.presenter.MessagePresenter;
import com.android.architecture_components.ui.adapter.MessageAdapter;
import com.android.architecture_components.ui.adapter.MessageItemCallback;
import com.android.architecture_components.viewmodel.MessageViewModel;

import butterknife.BindView;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity implements MessageRecyclerView {

    private MessagePresenter messagePresenter;

    private MessageAdapter messageAdapter;

    @BindView(R.id.activity_message_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.activity_message_edit_text)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        MessageViewModel.Factory factory = new MessageViewModel.Factory(getApplication());
        MessageViewModel messageViewModel = ViewModelProviders.of(this, factory).get(MessageViewModel.class);

        messagePresenter = new MessagePresenter(this, this, messageViewModel);
        messagePresenter.init();

        MessageItemCallback messageItemCallback = new MessageItemCallback();
        messageAdapter = new MessageAdapter(messageItemCallback);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(messageAdapter);
    }

    @Override
    public void submitList(@Nullable PagedList<Message> list) {
        messageAdapter.submitList(list);
    }

    @OnClick(R.id.activity_message_send_button)
    protected void onSendClicked() {
        messagePresenter.onSendClicked(editText.getText());
    }
}
