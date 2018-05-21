package com.android.architecture_components.work;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.collect.Maps;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;

import java.util.Map;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import io.reactivex.subjects.PublishSubject;

public abstract class BaseWorker extends Worker {

    private static PublishSubject<Object> publishSubject = PublishSubject.create();

    @Nullable
    protected String getString(String key) {
        return getInputData().getString(key, null);
    }

    @NonNull
    @Override
    public WorkerResult doWork() {
        try {
            publishSubject.blockingFirst();
            return WorkerResult.SUCCESS;
        } catch (Exception e) {
            return WorkerResult.FAILURE;
        }
    }

    public static class Builder<WORKER extends BaseWorker> {

        private final Map<String, Object> data = Maps.newHashMap();

        public Builder<WORKER> putData(String key, Object value) {
            data.put(key, value);
            return this;
        }

        public WorkRequest build(Class<WORKER> clazz) {
            Data.Builder dataBuilder = new Data.Builder();
            dataBuilder.putAll(data);
            return new OneTimeWorkRequest.Builder(clazz)
                    .setInputData(dataBuilder.build())
                    .build();
        }
    }

    protected static EkoWorkHandler workerHandler = new EkoWorkHandler() {

        @Override
        public void onConnected(User user, SendBirdException e) {
            handlerException(user, e);
        }

        @Override
        public void onResult(GroupChannel groupChannel, SendBirdException e) {
            handlerException(groupChannel, e);
        }

        private void handlerException(Object object, Exception e) {
            if (e != null) {
                publishSubject.onError(e);
            } else {
                publishSubject.onNext(object);
                publishSubject.onComplete();
            }
        }
    };
}
