package com.drewhannay.daggerandroiddemo.auth;

import com.drewhannay.daggerandroiddemo.di.scopes.PerApplication;

import javax.inject.Inject;

@PerApplication
public class AuthManagerTestImpl implements AuthManager {

    private boolean needsAuth;

    @Inject
    public AuthManagerTestImpl() {}

    public void setNeedsAuth(boolean needsAuth) {
        this.needsAuth = needsAuth;
    }

    @Override
    public boolean needsAuth() {
        // false by default
        return needsAuth;
    }

    @Override
    public void login(String email, String password, AuthCallback callback) {}

    @Override
    public void logout() {}
}
