package fr.isima.controller

import org.junit.Test

import org.assertj.core.api.Assertions.assertThat


class StringControllerTest {

    private val stringController = StringController()

    @Test
    fun concat_ABCandDEF_returnsABCDEF() {
        assertThat(this.stringController.join("ABC", "DEF")).isEqualTo("ABCDEF")
    }

    @Test
    fun substringBefore_42AvantWithPatternAv_returns42() {
        assertThat(this.stringController.substringBefore("42Avant", "Av")).isEqualTo("42")
    }

    @Test
    fun substringAfter_Apres42WithPatternres_returns42() {
        assertThat(this.stringController.substringAfter("Apres42", "res")).isEqualTo("42")
    }

}