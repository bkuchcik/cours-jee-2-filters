package fr.isima.controllers;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HiControllerTest {

    private HiController hiController;

    @Before
    public void setUp() throws Exception {
        this.hiController = new HiController();
    }

    @Test
    public void hi_returnsHi() throws Exception {
        assertThat(this.hiController.hi()).isEqualTo("Hi !");
    }
}