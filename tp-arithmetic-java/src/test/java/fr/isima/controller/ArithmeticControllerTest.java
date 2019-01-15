package fr.isima.controller;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArithmeticControllerTest {

    private ArithmeticController arithmeticController = new ArithmeticController();

    @Test
    public void diviser_5par2_returns2dot5() {
        assertThat(this.arithmeticController.divide(5, 2)).isIn("2,5", "2.5");
    }

    @Test
    public void soustraire_5par2_returns3() {
        assertThat(this.arithmeticController.soustraire(5, 2)).isEqualTo("3");
    }

    @Test
    public void additionner_5par2_returns7() {
        assertThat(this.arithmeticController.additionner(5, 2)).isEqualTo("7");
    }

    @Test
    public void multiplier_5par2_returns10() {
        assertThat(this.arithmeticController.multiplier(5, 2)).isEqualTo("10");
    }
}