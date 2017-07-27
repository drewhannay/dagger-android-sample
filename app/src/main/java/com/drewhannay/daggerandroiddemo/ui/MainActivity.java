package com.drewhannay.daggerandroiddemo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.drewhannay.daggerandroiddemo.R;
import com.drewhannay.daggerandroiddemo.auth.AuthManager;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject AuthManager authManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Fragment fragment = authManager.needsAuth() ? new FirstFragment() : new SecondFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
