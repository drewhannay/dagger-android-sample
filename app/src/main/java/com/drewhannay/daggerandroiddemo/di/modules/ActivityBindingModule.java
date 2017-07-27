package com.drewhannay.daggerandroiddemo.di.modules;

import com.drewhannay.daggerandroiddemo.di.scopes.PerActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.drewhannay.daggerandroiddemo.ui.MainActivity;
import com.drewhannay.daggerandroiddemo.ui.OtherActivity;

@Module
public abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = FragmentBindingModule.class)
    abstract MainActivity mainActivity();

    @PerActivity
    @ContributesAndroidInjector
    abstract OtherActivity otherActivity();
}
