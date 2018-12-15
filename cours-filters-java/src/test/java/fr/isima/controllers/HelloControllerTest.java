package fr.isima.controllers;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerTest {

    private HelloController helloController;

    @Before
    public void setUp() throws Exception {
        this.helloController = new HelloController();
    }

    @Test
    public void hello_returnHello() throws Exception {
        assertThat(this.helloController.hello()).isEqualTo("Hello !");
    }
}