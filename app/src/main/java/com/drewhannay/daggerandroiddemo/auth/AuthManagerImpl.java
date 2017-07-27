package com.drewhannay.daggerandroiddemo.auth;

import android.app.Application;
import com.drewhannay.daggerandroiddemo.di.scopes.PerApplication;
import com.drewhannay.daggerandroiddemo.util.AppExecutors;

import javax.inject.Inject;

@PerApplication
public class AuthManagerImpl implements AuthManager {

    private final Application application;
    private final AppExecutors appExecutors;

    private boolean needsAuth;

    @Inject
    public AuthManagerImpl(Application application, AppExecutors appExecutors) {
        // some sample dependencies :)
        this.application = application;
        this.appExecutors = appExecutors;

        this.needsAuth = true;
    }

    @Override
    public boolean needsAuth() {
        return needsAuth;
    }

    @Override
    public void login(String email, String password, AuthCallback callback) {
        // Login always succeeds!
        needsAuth = false;
    }

    @Override
    public void logout() {}
}
