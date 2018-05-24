package com.android.architecture_components.ui;

import android.arch.paging.PagedList;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.android.architecture_components.persistence.entity.SendBirdObject;

public interface BaseRecyclerView<OBJ extends SendBirdObject> extends BaseView {

    Intent getIntent();

    void submitList(@Nullable PagedList<OBJ> list);
}
