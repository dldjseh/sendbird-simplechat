package com.android.architecture_components.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.entity.User;
import com.android.architecture_components.ui.AuthView;
import com.android.architecture_components.viewmodel.UserViewModel;

public class AuthPresenter extends Presenter<AuthView, UserViewModel> {

    public AuthPresenter(LifecycleOwner lifecycleOwner, AuthView authView, UserViewModel userViewModel) {
        super(lifecycleOwner, authView, userViewModel);
    }

    @Override
    protected void observe() {
        androidViewModel.connect();

        androidViewModel.getUser().observe(lifecycleOwner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                view.submitUser(user);
            }
        });
    }

    @Override
    protected void initUI() {

    }
}
