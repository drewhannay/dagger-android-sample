package com.drewhannay.daggerandroiddemo;

import android.app.Activity;
import android.app.Application;
import com.drewhannay.daggerandroiddemo.di.ActivityAndFragmentAutoInjector;
import com.drewhannay.daggerandroiddemo.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import javax.inject.Inject;

public class MyApplication extends Application implements HasActivityInjector {

    @Inject ActivityAndFragmentAutoInjector autoInjector;
    @Inject DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().application(this).build().inject(this);
        autoInjector.setup(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
