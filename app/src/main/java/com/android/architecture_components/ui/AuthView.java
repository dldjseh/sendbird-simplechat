package com.android.architecture_components.ui;

import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.entity.User;

public interface AuthView extends BaseView {

    void submitUser(@Nullable User user);
}
