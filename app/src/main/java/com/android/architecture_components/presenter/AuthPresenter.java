package com.android.architecture_components.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.entity.User;
import com.android.architecture_components.ui.AuthView;
import com.android.architecture_components.viewmodel.UserViewModel;

import androidx.work.WorkStatus;

public class AuthPresenter extends Presenter<AuthView, UserViewModel> {

    public AuthPresenter(LifecycleOwner lifecycleOwner, AuthView authView, UserViewModel userViewModel) {
        super(lifecycleOwner, authView, userViewModel);
    }

    @Override
    protected void observe() {
        androidViewModel.connect().observe(lifecycleOwner, new Observer<WorkStatus>() {
            @Override
            public void onChanged(@Nullable WorkStatus workStatus) {

            }
        });

        androidViewModel.getUser().observe(lifecycleOwner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                // FIXME: 5/21/18 apply filter operation.
                if (user != null && user.isActive()) {
                    view.submitUser(user);
                }
            }
        });
    }

    @Override
    protected void initUI() {

    }
}
