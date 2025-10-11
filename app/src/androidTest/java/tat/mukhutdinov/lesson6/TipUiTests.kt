package tat.mukhutdinov.lesson6

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import tat.mukhutdinov.lesson6.ui.theme.TipTimeTheme
import java.text.NumberFormat

class TipUiTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        var billAmount = ""
        composeTestRule.setContent {
            billAmount = stringResource(id = R.string.bill_amount)

            TipTimeTheme {
                TipTimeLayout()
            }
        }

        composeTestRule.onNodeWithText(billAmount)
            .performTextInput("10")

        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with this text was found.")
    }
}