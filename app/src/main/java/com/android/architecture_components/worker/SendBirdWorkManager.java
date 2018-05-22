package com.android.architecture_components.worker;

import androidx.work.WorkManager;

public class SendBirdWorkManager {

    private static WorkManager workManager;

    public static WorkManager getInstance() {
        create();
        return workManager;
    }

    private static void create() {
        if (workManager == null) {
            workManager = WorkManager.getInstance();
        }
    }
}
