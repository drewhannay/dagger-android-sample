package com.drewhannay.daggerandroiddemo.di;

import android.app.Application;
import com.drewhannay.daggerandroiddemo.di.modules.ActivityBindingModule;
import com.drewhannay.daggerandroiddemo.di.modules.AppModule;
import com.drewhannay.daggerandroiddemo.di.scopes.PerApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import com.drewhannay.daggerandroiddemo.MyApplication;

@PerApplication
@Component(modules = {AppModule.class, ActivityBindingModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent {

    void inject(MyApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
