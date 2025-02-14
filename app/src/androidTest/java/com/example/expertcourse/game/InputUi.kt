package com.example.expertcourse.game

import android.view.KeyEvent
import android.view.View
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.isEnabled
import androidx.compose.ui.test.isNotEnabled
import androidx.compose.ui.text.TextLayoutInput
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.pressKey
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.google.android.material.textfield.TextInputEditText

import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import com.example.expertcourse.R
import com.google.android.material.textfield.TextInputLayout

class InputUi (
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
){

    private val layoutInteraction: ViewInteraction = onView(
        allOf(
            isAssignableFrom(TextInputLayout::class.java),
            withId(R.id.inputlayout),
            containerIdMatcher,
            containerClassTypeMatcher
        )
    )

    private val inputInteraction: ViewInteraction = onView(
        allOf(
            isAssignableFrom(TextInputEditText::class.java),
            withId(R.id.inputEditText),
            withParent(withId(R.id.inputlayout)),
            withParent(isAssignableFrom(TextInputLayout::class.java))
        )
    )

    fun assertInitialState() {
        layoutInteraction.check(matches(ViewMatchers.isEnabled())).
        check(matches(TextInputLayoutErrorEnabledMatcher(false)))
        inputInteraction.check(matches(withText("")))
    }


    fun addInput(text: String) {
        inputInteraction.perform(typeText(text), closeSoftKeyboard())
    }

    fun assertSufficientInputState() {
        layoutInteraction.check(matches(ViewMatchers.isEnabled())).
        check(matches(TextInputLayoutErrorEnabledMatcher(false)))
    }

    fun assertCorrectState() {
        layoutInteraction.check(matches(ViewMatchers.isNotEnabled())).
        check(matches(TextInputLayoutErrorEnabledMatcher(false)))
    }

    fun assertIncorrectState() {
        layoutInteraction.check(matches(ViewMatchers.isEnabled())).
        check(matches(TextInputLayoutErrorEnabledMatcher(true)))
    }

    fun initialState() {
        layoutInteraction.check(matches(ViewMatchers.isEnabled())).
        check(matches(TextInputLayoutErrorEnabledMatcher(false)))
    }

    fun removeInputLastLetter() {
        inputInteraction.perform(click(), pressKey(KeyEvent.KEYCODE_DEL), closeSoftKeyboard())
    }
}