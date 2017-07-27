package com.drewhannay.daggerandroiddemo;

import android.app.Activity;
import android.app.Application;
import com.drewhannay.daggerandroiddemo.di.AppInjector;
import com.drewhannay.daggerandroiddemo.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import javax.inject.Inject;

public class MyApplication extends Application implements HasActivityInjector {

    @Inject AppInjector appInjector;
    @Inject DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().application(this).build().inject(this);
        appInjector.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
