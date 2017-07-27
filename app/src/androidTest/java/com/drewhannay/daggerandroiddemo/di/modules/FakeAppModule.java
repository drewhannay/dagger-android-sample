package com.drewhannay.daggerandroiddemo.di.modules;

import com.drewhannay.daggerandroiddemo.auth.AuthManager;
import com.drewhannay.daggerandroiddemo.auth.AuthManagerTestImpl;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class FakeAppModule {

    @Binds
    abstract AuthManager authManager(AuthManagerTestImpl impl);
}
