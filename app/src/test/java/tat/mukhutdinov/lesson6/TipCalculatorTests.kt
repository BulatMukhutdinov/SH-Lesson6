package tat.mukhutdinov.lesson6

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val tip = 2
        val expectedTip = NumberFormat.getCurrencyInstance().format(tip)

        val actualTip = calculateTip(amount = amount, roundUp = false, tipPercent = tipPercent)

        assertEquals(expectedTip, actualTip)
    }

}


