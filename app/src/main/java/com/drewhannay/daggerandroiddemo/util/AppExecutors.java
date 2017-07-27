package com.drewhannay.daggerandroiddemo.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.drewhannay.daggerandroiddemo.di.scopes.PerApplication;

import javax.inject.Inject;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@PerApplication
public class AppExecutors {

    private final Executor diskIo;
    private final Executor networkIo;
    private final Executor mainThread;

    @Inject
    public AppExecutors() {
        diskIo = Executors.newSingleThreadExecutor();
        networkIo = Executors.newFixedThreadPool(3);
        mainThread = new MainThreadExecutor();
    }
    public Executor diskIo() {
        return diskIo;
    }

    public Executor networkIo() {
        return networkIo;
    }

    public Executor mainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {

        private final Handler handler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable runnable) {
            handler.post(runnable);
        }
    }
}
