package com.drewhannay.daggerandroiddemo.di.modules;

import com.drewhannay.daggerandroiddemo.di.scopes.PerFragment;
import com.drewhannay.daggerandroiddemo.ui.FirstFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.drewhannay.daggerandroiddemo.ui.SecondFragment;

@Module
public abstract class FragmentBindingModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract FirstFragment loginFragment();

    @PerFragment
    @ContributesAndroidInjector
    abstract SecondFragment feedFragment();
}
