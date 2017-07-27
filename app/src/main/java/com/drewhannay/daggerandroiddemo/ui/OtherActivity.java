package com.drewhannay.daggerandroiddemo.ui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import javax.inject.Inject;

public class OtherActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject DispatchingAndroidInjector<Fragment> fragmentInjector;

    // this activity doesn't really do anything and there's no way to even navigate to it
    // it's just a demo of having two activities

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
