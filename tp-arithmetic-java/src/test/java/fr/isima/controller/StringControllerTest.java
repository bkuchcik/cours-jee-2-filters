package fr.isima.controller;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringControllerTest {

    private StringController stringController = new StringController();

    @Test
    public void concat_ABCandDEF_returnsABCDEF() {
        assertThat(this.stringController.join("ABC", "DEF")).isEqualTo("ABCDEF");
    }

    @Test
    public void substringBefore_42AvantWithPatternAv_returns42() {
        assertThat(this.stringController.substringBefore("42Avant", "Av")).isEqualTo("42");
    }

    @Test
    public void substringAfter_Apres42WithPatternres_returns42() {
        assertThat(this.stringController.substringAfter("Apres42", "res")).isEqualTo("42");
    }

}