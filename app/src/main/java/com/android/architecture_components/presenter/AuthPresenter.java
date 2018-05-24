package com.android.architecture_components.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.android.architecture_components.repository.AuthRepository;
import com.android.architecture_components.viewmodel.AuthViewModel;
import com.android.architecture_components.ui.AuthView;

import androidx.work.WorkStatus;

public class AuthPresenter extends BasePresenter<AuthView, AuthRepository, AuthViewModel> {

    public AuthPresenter(LifecycleOwner lifecycleOwner, AuthView view, AuthRepository repository, AuthViewModel viewModel) {
        super(lifecycleOwner, view, repository, viewModel);
    }

    @Override
    protected void observeLiveData() {
        repository.connect().observe(lifecycleOwner, new Observer<WorkStatus>() {
            @Override
            public void onChanged(@Nullable WorkStatus workStatus) {
                // FIXME: 5/21/18 apply filter operation.
                if (workStatus != null && workStatus.getState().isFinished()) {
                    view.connect();
                }
            }
        });
    }
}
