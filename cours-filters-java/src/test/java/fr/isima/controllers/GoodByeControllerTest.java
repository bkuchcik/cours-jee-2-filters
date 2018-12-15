package fr.isima.controllers;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoodByeControllerTest {

    private GoodByeController goodByeController;

    @Before
    public void setUp() throws Exception {
        this.goodByeController = new GoodByeController();
    }

    @Test
    public void goodbye_returnGoodbyeString() {
        assertThat(this.goodByeController.goodBye()).isEqualTo("GoodBye !");
    }
}