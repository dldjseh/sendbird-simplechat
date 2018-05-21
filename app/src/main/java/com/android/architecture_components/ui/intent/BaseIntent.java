package com.android.architecture_components.ui.intent;

import android.content.Context;
import android.content.Intent;

public class BaseIntent extends Intent {

    private static int requestCode;

    protected BaseIntent(Context packageContext, Class<?> cls) {
        super(packageContext, cls);
        // FIXME: 5/21/18
        requestCode = 0;
    }

    public int getRequestCode() {
        return requestCode;
    }
}
