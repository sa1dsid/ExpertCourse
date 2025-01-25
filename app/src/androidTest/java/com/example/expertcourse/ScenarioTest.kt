package com.example.expertcourse

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class ScenarioTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var gamePage: GamePage()

    @Before
    fun setup(){
        gamePage = GamePage(word = "animal".reversed())
    }

    /**
     * UG-01
     */
    @Test
    fun testcase1() {
        val gamePage = GamePage(word = "animal".reversed())

        gamePage.assertInitialState()

        gamePage.input(text = "animal")
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertCorrectState()

        gamePage.clickNext()
    }
    fun testcase2() {
        val gamePage = GamePage(word = "animal".reversed())

        gamePage.assertInitialState()

        gamePage.input(text = "anima")
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertIncorrectState()

        gamePage.input(text = "animal")
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertCorrectState()
    }
    fun testcase3() {
        val gamePage = GamePage(word = "animal".reversed())

        gamePage.assertInitialState()

        gamePage.input(text = "anima")
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertIncorrectState()

        gamePage.clickSkip()
        gamePage.InitialState()
    }
}