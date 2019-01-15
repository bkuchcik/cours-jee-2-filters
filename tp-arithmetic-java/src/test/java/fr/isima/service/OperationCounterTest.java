package fr.isima.service;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationCounterTest {

    private OperationCounter operationCounter = new OperationCounter();

    @Test
    public void countRequest_maths_returnsToStringWithMathIncrementedByOne() throws Exception {
        assertThat(operationCounter.countRequest("/maths")).isEqualTo("Math ops : 1 and string ops 0");
    }

    @Test
    public void countRequest_strings_returnsToStringWithStringsIncrementedByOne() throws Exception {
        assertThat(operationCounter.countRequest("/strings")).isEqualTo("Math ops : 0 and string ops 1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void countRequest_noBoundedPath_thorws() throws Exception {
        operationCounter.countRequest("/inconnu");
    }

}