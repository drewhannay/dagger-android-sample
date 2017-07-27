package com.drewhannay.daggerandroiddemo.auth;

public interface AuthManager {

    boolean needsAuth();

    void login(String email, String password, AuthCallback callback);

    void logout();

    interface AuthCallback {
        void onLoginAttempt(boolean success);
    }
}
