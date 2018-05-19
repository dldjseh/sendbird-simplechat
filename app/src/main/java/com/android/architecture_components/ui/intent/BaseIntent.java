package com.android.architecture_components.ui.intent;

import android.content.Context;
import android.content.Intent;

public class BaseIntent extends Intent {

    private static int requestCode;

    protected BaseIntent(Context packageContext, Class<?> cls) {
        super(packageContext, cls);
        requestCode = cls.getSimpleName().hashCode();
    }

    public int getRequestCode() {
        return requestCode;
    }
}
