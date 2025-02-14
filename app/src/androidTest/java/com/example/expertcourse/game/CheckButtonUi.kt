package com.example.expertcourse.game

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.compose.ui.test.isNotEnabled
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import com.example.expertcourse.R


class CheckButtonUi(
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
): AbstractButtonUi(
    onView(
        allOf(
            withId(R.id.checkButton),
            withText(R.string.check),
            isAssignableFrom(AppCompatButton::class.java),
            ButtonColorMatcher("#809EDF"),
            containerIdMatcher,
            containerClassTypeMatcher
        )
    )
){
    fun assertVisibleDisabled() {
        interaction.check(matches(ViewMatchers.isNotEnabled()))
            .check(matches(isCompletelyDisplayed()))
    }

    fun assertVisibleEnabled() {
        interaction.check(matches(ViewMatchers.isEnabled()))
            .check(matches(isCompletelyDisplayed()))
    }
}