package com.android.architecture_components.worker;

import androidx.work.WorkManager;

public class SendBirdWorkManager {

    private static volatile WorkManager workManager;

    public static synchronized WorkManager getInstance() {
        if (workManager == null) {
            workManager = WorkManager.getInstance();
        }
        return workManager;
    }
}
