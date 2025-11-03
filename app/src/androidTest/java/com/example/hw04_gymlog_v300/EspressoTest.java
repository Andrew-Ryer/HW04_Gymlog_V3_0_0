package com.example.hw04_gymlog_v300;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EspressoTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.hw04_gymlog_v300", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule<LoginActivity> rule = new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void login_and_logout() {

        // Sign in with admin1/admin1
        onView(withId(R.id.userNameLoginEditText)).perform(typeText("admin1"));
        onView(withId(R.id.passwordLoginEditText)).perform(typeText("admin1"));
        onView(withId(R.id.loginButton)).perform(click());

        // Add a log
//        onView(withId(R.id.gymLogEditText)).perform(typeText(logText));
//        onView(withId(R.id.addLogButton)).perform(click());
//        onView(withText(logText)).check(matches(isDisplayed()));

        // Sign out (overflow menu -> "Logout")
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext());
        onView(withText("Logout")).perform(click());

        // Sign in again and see the log
        onView(withId(R.id.userNameLoginEditText)).perform(typeText("admin1"));
        onView(withId(R.id.passwordLoginEditText)).perform(typeText("admin1"));
        onView(withId(R.id.loginButton)).perform(click());
//        onView(withText(logText)).check(matches(isDisplayed()));
    }
}