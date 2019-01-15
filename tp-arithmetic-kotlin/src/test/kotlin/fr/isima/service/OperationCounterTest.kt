package fr.isima.service


import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class OperationCounterTest {

    private val operationCounter = OperationCounter()

    @Test
    @Throws(Exception::class)
    fun countRequest_maths_returnsToStringWithMathIncrementedByOne() {
        assertThat(operationCounter.countRequest("/maths")).isEqualTo("Math ops : 1 and string ops 0")
    }

    @Test
    @Throws(Exception::class)
    fun countRequest_strings_returnsToStringWithStringsIncrementedByOne() {
        assertThat(operationCounter.countRequest("/strings")).isEqualTo("Math ops : 0 and string ops 1")
    }

    @Test(expected = IllegalArgumentException::class)
    @Throws(Exception::class)
    fun countRequest_noBoundedPath_thorws() {
        operationCounter.countRequest("/inconnu")
    }

}