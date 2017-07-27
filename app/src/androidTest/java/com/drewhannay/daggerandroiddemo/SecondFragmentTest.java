package com.drewhannay.daggerandroiddemo;

import android.support.test.rule.ActivityTestRule;
import com.drewhannay.daggerandroiddemo.ui.MainActivity;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;

public class SecondFragmentTest {

    @Rule public final ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void displaySecondFragment() {
        // This test will pass because AuthManagerTestImpl is used and is logged in by default
        onView(withContentDescription("Second Fragment")).check(matches(isDisplayed()));
    }
}
