package com.drewhannay.daggerandroiddemo;

import android.support.test.rule.ActivityTestRule;
import com.drewhannay.daggerandroiddemo.ui.MainActivity;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;

public class FirstFragmentTest {

    @Rule public final ActivityTestRule<MainActivity> activity =
            new ActivityTestRule<>(MainActivity.class, false, false);

    @Before
    public void setUp() {
        TestApplication.appComponent().authManager().setNeedsAuth(true);
    }

    @After
    public void tearDown() {
        // reset our state so feed tests don't fail!
        TestApplication.appComponent().authManager().setNeedsAuth(false);
    }

    @Test
    public void displayFirstFragment() {
        activity.launchActivity(null);

        onView(withContentDescription("First Fragment")).check(matches(isDisplayed()));
    }
}
