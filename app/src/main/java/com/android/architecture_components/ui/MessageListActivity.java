package com.android.architecture_components.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.android.architecture_components.R;
import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.dao.MessageDao;
import com.android.architecture_components.persistence.entity.Message;
import com.android.architecture_components.presenter.MessageListPresenter;
import com.android.architecture_components.repository.MessageListRepository;
import com.android.architecture_components.ui.adapter.MessageAdapter;
import com.android.architecture_components.ui.adapter.MessageItemCallback;
import com.android.architecture_components.viewmodel.MessageListViewModel;

import butterknife.BindView;
import butterknife.OnClick;

public class MessageListActivity extends BaseActivity implements MessageRecyclerView {

    private MessageListPresenter messagePresenter;

    private MessageAdapter messageAdapter;

    @BindView(R.id.activity_message_list_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.activity_message_list_edit_text)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        MessageDao dao = ChatDatabase.getInstance(this).getMessageDao();
        MessageListRepository repository = new MessageListRepository(dao);

        MessageListViewModel.Factory factory = new MessageListViewModel.Factory(getApplication(), repository);
        MessageListViewModel viewModel = ViewModelProviders.of(this, factory).get(MessageListViewModel.class);

        messagePresenter = new MessageListPresenter(this, this, repository, viewModel);

        messageAdapter = new MessageAdapter(new MessageItemCallback());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(messageAdapter);
    }

    @Override
    public void submitList(@Nullable PagedList<Message> list) {
        messageAdapter.submitList(list);
    }

    @OnClick(R.id.activity_message_list_send_button)
    protected void onSendClicked() {
        messagePresenter.onSendClicked(editText.getText());
    }
}
