package com.example.expertcourse.game

import android.view.View
import android.widget.Button
import androidx.compose.ui.text.TextLayoutInput
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description

class TextInputLayoutErrorEnabledMatcher(private val expectingEnabled: Boolean):
    BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {

    override fun describeTo(description: Description?) {
        description?.appendText("error enabled doesn't match with expected ${expectingEnabled}))
    }

    override fun matchesSafely(item: TextLayoutInput?): Boolean {
        return item.isErrorEnabled == expectingEnabled
    }

}