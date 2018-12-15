package fr.isima.filters

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.mockito.Mockito.*

@RunWith(MockitoJUnitRunner::class)
class NickMandatoryFilterTest {

    @Mock
    private val httpServletRequest: HttpServletRequest? = null

    @Mock
    private val httpServletResponse: HttpServletResponse? = null

    @Mock
    private val filterChain: FilterChain? = null

    private val nickMandatoryFilter = NickMandatoryFilter()

    @Test
    @Throws(Exception::class)
    fun doFilter_NoNick_sendError401() {
        this.nickMandatoryFilter.doFilter(this.httpServletRequest!!, this.httpServletResponse!!, this.filterChain!!)
        verify(this.httpServletResponse).sendError(401, "Je ne dis pas bonjour aux inconnus")
        verify(this.filterChain, times(0)).doFilter(this.httpServletRequest, this.httpServletResponse)
    }

    @Test
    @Throws(Exception::class)
    fun doFilter_Nick_continueFilterChain() {
        `when`(this.httpServletRequest!!.getParameter("nick")).thenReturn("A nick")
        this.nickMandatoryFilter.doFilter(this.httpServletRequest, this.httpServletResponse!!, this.filterChain!!)
        verify(this.filterChain).doFilter(this.httpServletRequest, this.httpServletResponse)
    }
}