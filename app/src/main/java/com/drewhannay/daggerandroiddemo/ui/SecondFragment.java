package com.drewhannay.daggerandroiddemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.drewhannay.daggerandroiddemo.di.Injectable;

public class SecondFragment extends Fragment implements Injectable {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = new View(getContext());
        view.setContentDescription("Second Fragment");
        return view;
    }
}
