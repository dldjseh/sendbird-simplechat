package com.android.architecture_components.work;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.Worker;

public abstract class BaseWorker extends Worker {

    public static class Builder<WORKER extends BaseWorker> {

        public WorkRequest build(Class<WORKER> clazz) {
            return new OneTimeWorkRequest.Builder(clazz).build();
        }
    }
}
