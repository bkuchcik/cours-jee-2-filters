package fr.isima.controller

import org.junit.Test

import org.assertj.core.api.AssertionsForClassTypes.assertThat

class ArithmeticControllerTest {

    private val arithmeticController = ArithmeticController()

    @Test
    fun diviser_5par2_returns2dot5() {
        assertThat(this.arithmeticController.divide(5.0, 2.0)).isIn("2,5", "2.5")
    }

    @Test
    fun soustraire_5par2_returns3() {
        assertThat(this.arithmeticController.soustraire(5.0, 2.0)).isEqualTo("3")
    }

    @Test
    fun additionner_5par2_returns7() {
        assertThat(this.arithmeticController.additionner(5.0, 2.0)).isEqualTo("7")
    }

    @Test
    fun multiplier_5par2_returns10() {
        assertThat(this.arithmeticController.multiplier(5.0, 2.0)).isEqualTo("10")
    }
}