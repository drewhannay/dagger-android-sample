package com.drewhannay.daggerandroiddemo.di;

import android.app.Application;
import com.drewhannay.daggerandroiddemo.TestApplication;
import com.drewhannay.daggerandroiddemo.auth.AuthManagerTestImpl;
import com.drewhannay.daggerandroiddemo.di.modules.ActivityBindingModule;
import com.drewhannay.daggerandroiddemo.di.modules.FakeAppModule;
import com.drewhannay.daggerandroiddemo.di.scopes.PerApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        FakeAppModule.class, ActivityBindingModule.class, AndroidSupportInjectionModule.class
})
@PerApplication
public interface TestAppComponent extends AppComponent {

    void inject(TestApplication application);

    AuthManagerTestImpl authManager();

    @Component.Builder
    interface Builder {
        @BindsInstance
        TestAppComponent.Builder application(Application application);

        TestAppComponent build();
    }
}
