package com.android.architecture_components.presenter;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;

import com.android.architecture_components.ui.BaseView;

public abstract class Presenter<V extends BaseView, AVM extends AndroidViewModel> {

    protected final LifecycleOwner lifecycleOwner;
    protected final V view;
    protected final AVM androidViewModel;

    protected Presenter(LifecycleOwner lifecycleOwner, V view, AVM androidViewModel) {
        this.view = view;
        this.lifecycleOwner = lifecycleOwner;
        this.androidViewModel = androidViewModel;
    }

    public final void init() {
        observe();
    }

    abstract protected void observe();
}
