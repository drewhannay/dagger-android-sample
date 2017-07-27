package com.drewhannay.daggerandroiddemo.di.modules;

import com.drewhannay.daggerandroiddemo.auth.AuthManager;
import com.drewhannay.daggerandroiddemo.auth.AuthManagerImpl;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppModule {

    @Binds
    abstract AuthManager authManager(AuthManagerImpl impl);
}
