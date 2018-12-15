package fr.isima.filters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NickMandatoryFilterTest {

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

    @Mock
    private FilterChain filterChain;

    private NickMandatoryFilter nickMandatoryFilter = new NickMandatoryFilter();

    @Test
    public void doFilter_NoNick_sendError401() throws Exception {
        this.nickMandatoryFilter.doFilter(this.httpServletRequest, this.httpServletResponse, this.filterChain);
        verify(this.httpServletResponse).sendError(401, "Je ne dis pas bonjour aux inconnus");
        verify(this.filterChain, times(0)).doFilter(this.httpServletRequest, this.httpServletResponse);
    }

    @Test
    public void doFilter_Nick_continueFilterChain() throws Exception {
        when(this.httpServletRequest.getParameter("nick")).thenReturn("A nick");
        this.nickMandatoryFilter.doFilter(this.httpServletRequest, this.httpServletResponse, this.filterChain);
        verify(this.filterChain).doFilter(this.httpServletRequest, this.httpServletResponse);
    }
}