package controllers

import fr.isima.controllers.GoodByeController
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GoodByeControllerTest {

    private val goodByeController = GoodByeController()

    @Test
    fun goodbye_returnGoodbyeString() {
        assertThat(this.goodByeController.goodBye()).isEqualTo("GoodBye !")
    }
}