package fr.isima.filters

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

@RunWith(MockitoJUnitRunner::class)
class MandatoryMathsOperatorFilterTest {

    @Rule
    @JvmField
    val expectedException = ExpectedException.none()

    @Mock
    private lateinit var request: HttpServletRequest

    @Mock
    private lateinit var  response: HttpServletResponse

    @Mock
    private lateinit var  filterChain: FilterChain

    private val mandatoryMathsOperatorFilter = MandatoryMathsOperatorFilter()

    @Test
    fun doFilter_noParameter_throwsServletException() {
        expectedException.expect(ServletException::class.java)
        expectedException.expectMessage("Membres a et b obligatoires")
        this.mandatoryMathsOperatorFilter.doFilter(this.request, this.response, this.filterChain)
    }

    @Test
    fun doFilter_onlyAParameter_throwsServletException() {
        expectedException.expect(ServletException::class.java)
        expectedException.expectMessage("Membre b obligatoire")
        `when`(this.request.getParameter("a")).thenReturn("42")
        this.mandatoryMathsOperatorFilter.doFilter(this.request, this.response, this.filterChain)
    }

    @Test
    @Throws(IOException::class, ServletException::class)
    fun doFilter_onlyBParameter_throwsServletException() {
        expectedException.expect(ServletException::class.java)
        expectedException.expectMessage("Membre a obligatoire")
        `when`(this.request.getParameter("b")).thenReturn("42")
        this.mandatoryMathsOperatorFilter.doFilter(this.request, this.response, this.filterChain)
    }

    @Test
    @Throws(IOException::class, ServletException::class)
    fun doFilter_withAandBParameters_CallChainFilter() {
        `when`(this.request.getParameter("a")).thenReturn("42")
        `when`(this.request.getParameter("b")).thenReturn("42")
        this.mandatoryMathsOperatorFilter.doFilter(this.request, this.response, this.filterChain)
        verify(this.filterChain).doFilter(this.request, this.response)
    }

}