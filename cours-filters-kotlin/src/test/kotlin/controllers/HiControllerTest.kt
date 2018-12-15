package controllers

import fr.isima.controllers.HiController
import org.junit.Before
import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class HiControllerTest {

    private val hiController: HiController = HiController()

    @Test
    fun hi_returnsHi() {
        assertThat(this.hiController.hi()).isEqualTo("Hi !")
    }
}