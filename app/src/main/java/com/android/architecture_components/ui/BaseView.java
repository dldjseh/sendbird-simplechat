package com.android.architecture_components.ui;

import android.arch.paging.PagedList;
import android.support.annotation.Nullable;

import com.android.architecture_components.internal.entity.SendBirdObject;

public interface BaseView<OBJ extends SendBirdObject> {

    void submitList(@Nullable PagedList<OBJ> list);
}
