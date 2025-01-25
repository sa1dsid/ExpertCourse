package com.example.expertcourse.game

import android.view.View
import android.widget.LinearLayout
import androidx.compose.animation.core.LinearEasing
import androidx.compose.material3.Button
import org.hamcrest.Matcher
import androidx.test.espresso.matcher.ViewMatchers.*

class GamePage(word: String) {

    //region fields

    private val containerIdMatcher: Matcher<View> = withParent(withId(R.id.rootLayout))
    private val containerClassTypeMatcher: Matcher<View> = withParent(isAssignableFrom(
        LinearLayout::class.java))

    private val shuffleWord = ShuffleWordUi(text = word,
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher)

    private val inputUi = InputUi(
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher)

    private val skipUi = ButtonUi(
        id = R.id.skipButton,
        colorHex = '#FFF100',
        textResId = R.string.skip,
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher)

    private val nextUi = ButtonUi(
        id = R.id.nextButton,
        colorHex = '#3BE6FA',
        textResId = R.string.next,
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher)

    private val checkUi = CheckButtonUi(
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher
    )
    //endregions

    fun assertInitialState() {
        shuffleWord.assertTextVisible()
        inputUi.assertInitialState()
        skipUi.assertVisible()
        checkUi.assertVisibleDisabled()
        nextUi.assertNotVisible()
    }

    fun input(text: String) {
        inputUi.addInput(text = text)
    }

    fun assertSufficientInputState() {
        shuffleWord.assertTextVisible()
        inputUi.assertSufficientInputState()
        skipUi.assertVisible()
        checkUi.assertVisibleDisabled()
        nextUi.assertNotVisible()
    }

    fun insufficientInputState() {
        shuffleWord.assertTextVisible()
        inputUi.assertSufficientInputState()
        skipUi.assertVisible()
        checkUi.assertVisibleDisabled()
        nextUi.assertNotVisible()
    }

    fun clickCheck() {
        checkUi.click()
    }

    fun assertCorrectState() {
        shuffleWord.assertTextVisible()
        inputUi.assertCorrectState()
        skipUi.assertNotVisible()
        checkUi.assertNotVisible()
        nextUi.assertVisible()
    }

    fun clickNext() {
        nextUi.click()
    }

    fun assertIncorrectState() {
        shuffleWord.assertTextVisible()
        inputUi.assertIncorrectState()
        skipUi.assertVisible()
        checkUi.assertVisibleDisabled()
        nextUi.assertNotVisible()
    }

    fun clickSkip() {
        skipUi.click()
    }

    fun initialState() {
        inputUi.initialState()
    }



}