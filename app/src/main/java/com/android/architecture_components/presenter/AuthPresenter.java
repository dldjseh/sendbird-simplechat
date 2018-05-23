package com.android.architecture_components.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.android.architecture_components.data.repository.UserRepository;
import com.android.architecture_components.data.viewmodel.UserViewModel;
import com.android.architecture_components.persistence.entity.User;
import com.android.architecture_components.ui.AuthView;

import androidx.work.WorkStatus;

public class AuthPresenter extends BasePresenter<AuthView, UserRepository, UserViewModel> {

    public AuthPresenter(LifecycleOwner lifecycleOwner, AuthView view, UserRepository repository, UserViewModel viewModel) {
        super(lifecycleOwner, view, repository, viewModel);
    }

    @Override
    protected void observeLiveData() {
        androidViewModel.getFirstLiveData().observe(lifecycleOwner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                // FIXME: 5/21/18 apply filter operation.
                if (user != null) {
                    view.submitUser(user);
                }
            }
        });

        repository.connect().observe(lifecycleOwner, new Observer<WorkStatus>() {
            @Override
            public void onChanged(@Nullable WorkStatus workStatus) {

            }
        });
    }
}
