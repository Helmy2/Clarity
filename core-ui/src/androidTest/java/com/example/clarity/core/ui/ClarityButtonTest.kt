package com.example.clarity.core.ui

import androidx.compose.material3.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ClarityButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun clarityButton_isDisplayed() {
        composeTestRule.setContent {
            ClarityTheme {
                ClarityButton(onClick = {}) {
                    Text("Click Me")
                }
            }
        }

        composeTestRule.onNodeWithText("Click Me").assertIsDisplayed()
    }

    @Test
    fun clarityButton_isClickable() {
        var clicked = false
        composeTestRule.setContent {
            ClarityTheme {
                ClarityButton(onClick = { clicked = true }) {
                    Text("Click Me")
                }
            }
        }

        composeTestRule.onNodeWithText("Click Me").performClick()
        assert(clicked)
    }
}
