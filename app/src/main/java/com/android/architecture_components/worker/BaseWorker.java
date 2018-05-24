package com.android.architecture_components.worker;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.collect.Maps;

import java.util.HashMap;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public abstract class BaseWorker<RESULT> extends Worker {

    private static PublishSubject<Object> publishSubject = PublishSubject.create();

    @Nullable
    protected String getString(String key) {
        return getInputData().getString(key, null);
    }

    @Nullable
    protected String[] getStringArray(String key) {
        return getInputData().getStringArray(key);
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

        private final HashMap<String, String> data = Maps.newHashMap();

        public Builder<WORKER> putString(String key, String value) {
            data.put(key, value);
            return this;
        }

        public WorkRequest build(Class<WORKER> clazz) {
            Data.Builder dataBuilder = new Data.Builder();
            for (String key : data.keySet()) {
                dataBuilder.putString(key, data.get(key));
            }
            return new OneTimeWorkRequest.Builder(clazz)
                    .setInputData(dataBuilder.build())
                    .build();
        }
    }

    final void handlerException(RESULT result, Exception e) {
        if (e != null) {
            publishSubject.onError(e);
        } else {
            Flowable.just(result)
                    .observeOn(Schedulers.io())
                    .doOnNext(new Consumer<RESULT>() {
                        @Override
                        public void accept(RESULT result) throws Exception {
                            handleResult(result);
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(new Consumer<RESULT>() {
                        @Override
                        public void accept(RESULT result) throws Exception {
                            publishSubject.onNext(result);
                            publishSubject.onComplete();
                        }
                    })
                    .doOnError(new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            publishSubject.onError(throwable);
                        }
                    })
                    .subscribe();
        }
    }

    protected void handleResult(RESULT result) {

    }
}
