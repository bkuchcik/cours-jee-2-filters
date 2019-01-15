package fr.isima.filters;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MandatoryMathsOperatorFilterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    private MandatoryMathsOperatorFilter mandatoryMathsOperatorFilter = new MandatoryMathsOperatorFilter();

    @Test
    public void doFilter_noParameter_throwsServletException() throws IOException, ServletException {
        expectedException.expect(ServletException.class);
        expectedException.expectMessage("Membres a et b obligatoires");
        this.mandatoryMathsOperatorFilter.doFilter(this.request, this.response, this.filterChain);
    }

    @Test
    public void doFilter_onlyAParameter_throwsServletException() throws IOException, ServletException {
        expectedException.expect(ServletException.class);
        expectedException.expectMessage("Membre b obligatoire");
        when(this.request.getParameter("a")).thenReturn("42");
        this.mandatoryMathsOperatorFilter.doFilter(this.request, this.response, this.filterChain);
    }

    @Test
    public void doFilter_onlyBParameter_throwsServletException() throws IOException, ServletException {
        expectedException.expect(ServletException.class);
        expectedException.expectMessage("Membre a obligatoire");
        when(this.request.getParameter("b")).thenReturn("42");
        this.mandatoryMathsOperatorFilter.doFilter(this.request, this.response, this.filterChain);
    }

    @Test
    public void doFilter_withAandBParameters_CallChainFilter() throws IOException, ServletException {
        when(this.request.getParameter("a")).thenReturn("42");
        when(this.request.getParameter("b")).thenReturn("42");
        this.mandatoryMathsOperatorFilter.doFilter(this.request, this.response, this.filterChain);
        verify(this.filterChain).doFilter(this.request, this.response);
    }

}