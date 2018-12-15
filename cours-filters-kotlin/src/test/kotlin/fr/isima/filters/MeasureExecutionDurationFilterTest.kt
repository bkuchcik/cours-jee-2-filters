package fr.isima.filters

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

import org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner::class)
class MeasureExecutionDurationFilterTest {

    @Mock
    private val httpServletRequest: HttpServletRequest? = null

    @Mock
    private val httpServletResponse: HttpServletResponse? = null

    @Mock
    private val filterChain: FilterChain? = null

    private val measureExecutionDurationFilter = MeasureExecutionDurationFilter()

    //le test n'a pas d'output facile à vérifier, mais on peut
    //tout de même valider que la filter chain n'est pas interrompu
    // ps system.out ne doit pas figurer dans des codes de production
    // il faut utiliser des loggers
    @Test
    @Throws(IOException::class, ServletException::class)
    fun doFilter_AlwaysContinueFilterChain() {
        this.measureExecutionDurationFilter
                .doFilter(this.httpServletRequest!!, this.httpServletResponse!!, this.filterChain!!)
        verify(this.filterChain).doFilter(this.httpServletRequest, this.httpServletResponse)
    }
}