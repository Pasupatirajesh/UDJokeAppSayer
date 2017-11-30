import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.jakewharton.espresso.OkHttp3IdlingResource;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import okhttp3.OkHttpClient;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.udacity.gradle.builditbigger.AsyncTaskUnitTest.childAtPosition;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by SSubra27 on 11/27/17.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTaskUnitTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule
             = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickTellJokeButton(){
        // Find the view
        // Perform action on the view
        // Check if the view does what you expect it to do
        IdlingResource idlingResource = OkHttp3IdlingResource.create("okhttp",
                new OkHttpClient());
        IdlingRegistry.getInstance().register(idlingResource);

        onView(allOf(withId(R.id.button2), withText("Tell Joke"),
                childAtPosition(childAtPosition(withId(android.R.id.content), 0),1),isDisplayed())).perform(click());


        ViewInteraction textView = onView(
                allOf(withId(R.id.textView2), withText("Hi this is a joke"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));

        textView.check(matches(withText("Hi this is a joke")));

        IdlingRegistry.getInstance().unregister(idlingResource);

    }


}
