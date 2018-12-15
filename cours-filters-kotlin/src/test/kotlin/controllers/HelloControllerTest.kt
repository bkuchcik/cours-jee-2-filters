package controllers

import fr.isima.controllers.HelloController
import org.junit.Before
import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class HelloControllerTest {

    private val helloController: HelloController = HelloController()


    @Test
    fun hello_returnHello() {
        assertThat(this.helloController.hello()).isEqualTo("Hello !")
    }
}