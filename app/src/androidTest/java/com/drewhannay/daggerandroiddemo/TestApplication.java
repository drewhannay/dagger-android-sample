package com.drewhannay.daggerandroiddemo;

import android.app.Activity;
import android.app.Application;
import android.support.test.InstrumentationRegistry;
import com.drewhannay.daggerandroiddemo.di.AppInjector;
import com.drewhannay.daggerandroiddemo.di.DaggerTestAppComponent;
import com.drewhannay.daggerandroiddemo.di.TestAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import javax.inject.Inject;

public class TestApplication extends Application implements HasActivityInjector {

    @Inject DispatchingAndroidInjector<Activity> injector;
    @Inject AppInjector appInjector;

    private TestAppComponent appComponent;

    @Override
    public void onCreate() {
        // Android Studio won't recognize the generated class due to https://issuetracker.google.com/issues/37121918
        // but the code will still build!
        appComponent = DaggerTestAppComponent.builder().application(this).build();
        appComponent.inject(this);

        super.onCreate();

        appInjector.inject(this);
    }

    public static TestAppComponent appComponent() {
        return ((TestApplication) InstrumentationRegistry.getTargetContext().getApplicationContext()).appComponent;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return injector;
    }
}
