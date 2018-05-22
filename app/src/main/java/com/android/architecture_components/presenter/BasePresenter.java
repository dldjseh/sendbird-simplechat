package com.android.architecture_components.presenter;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;

import com.android.architecture_components.data.repository.BaseRepository;
import com.android.architecture_components.ui.BaseView;

public abstract class BasePresenter<V extends BaseView, REPO extends BaseRepository, AVM extends AndroidViewModel> {

    final LifecycleOwner lifecycleOwner;
    final V view;
    final REPO repository;
    final AVM androidViewModel;

    BasePresenter(LifecycleOwner lifecycleOwner, V view, REPO repository, AVM androidViewModel) {
        this.lifecycleOwner = lifecycleOwner;
        this.view = view;
        this.repository = repository;
        this.androidViewModel = androidViewModel;
        init();
        registerChannelEvent();
    }

    abstract protected void init();

    abstract protected void registerChannelEvent();
}
