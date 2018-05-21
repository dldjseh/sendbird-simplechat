package com.android.architecture_components.ui;


import com.android.architecture_components.persistence.entity.User;

public interface AuthView extends BaseView {

    void submitUser(User user);
}
