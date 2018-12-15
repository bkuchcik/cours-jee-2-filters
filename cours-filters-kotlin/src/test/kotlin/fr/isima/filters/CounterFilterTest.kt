package fr.isima.filters


import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner::class)
class CounterFilterTest {

    @Mock
    private lateinit var httpServletRequest: HttpServletRequest

    @Mock
    private lateinit var httpServletResponse: HttpServletResponse

    @Mock
    private lateinit var filterChain: FilterChain

    private val counterFilter = CounterFilter()

    @Before
    fun setUp() {
        this.counterFilter.init(mock(FilterConfig::class.java))
    }

    @Test
    fun counter_filterWithRequestAndResponse_shouldBeIncremented() {
        this.counterFilter.doFilter(
                this.httpServletRequest,
                this.httpServletResponse,
                this.filterChain
        )
        assertThat(this.counterFilter.getCounter()).isEqualTo(1L)
        verify(this.filterChain).doFilter(this.httpServletRequest, this.httpServletResponse)
    }


}