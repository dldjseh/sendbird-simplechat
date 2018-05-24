package com.android.architecture_components.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.architecture_components.R;
import com.android.architecture_components.persistence.ChatDatabase;
import com.android.architecture_components.persistence.dao.UserDao;
import com.android.architecture_components.presenter.AuthPresenter;
import com.android.architecture_components.repository.AuthRepository;
import com.android.architecture_components.ui.intent.ChannelListIntent;
import com.android.architecture_components.viewmodel.AuthViewModel;

public class AuthActivity extends BaseActivity implements AuthView {

    private AuthPresenter authPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        UserDao dao = ChatDatabase.getInstance(this).getUserDao();
        AuthRepository repository = new AuthRepository(dao);

        AuthViewModel.Factory factory = new AuthViewModel.Factory(getApplication(), repository);
        AuthViewModel viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel.class);

        authPresenter = new AuthPresenter(this, this, repository, viewModel);
    }

    @Override
    public void connect() {
        ChannelListIntent intent = new ChannelListIntent(this);
        startActivityForResult(intent, intent.getRequestCode());
        finish();
    }
}
