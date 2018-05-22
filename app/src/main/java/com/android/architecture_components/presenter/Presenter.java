package com.android.architecture_components.presenter;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;

import com.android.architecture_components.data.repository.SendBirdRepository;
import com.android.architecture_components.ui.BaseView;

public abstract class Presenter<V extends BaseView, REPO extends SendBirdRepository, AVM extends AndroidViewModel> {

    protected final LifecycleOwner lifecycleOwner;
    protected final V view;
    protected final REPO repository;
    protected final AVM androidViewModel;

    protected Presenter(LifecycleOwner lifecycleOwner, V view, REPO repository, AVM androidViewModel) {
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
