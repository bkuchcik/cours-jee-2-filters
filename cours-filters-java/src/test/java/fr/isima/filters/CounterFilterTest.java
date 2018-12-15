package fr.isima.filters;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CounterFilterTest {

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

    @Mock
    private FilterChain filterChain;

    private CounterFilter counterFilter = new CounterFilter();

    @Before
    public void setUp() throws Exception {
        this.counterFilter.init(mock(FilterConfig.class));
    }

    @Test
    public void counter_filterWithRequestAndResponse_shouldBeIncremented() throws Exception {
        this.counterFilter.doFilter(this.httpServletRequest, this.httpServletResponse, this.filterChain);
        assertThat(this.counterFilter.getCounter()).isEqualTo(1l);
        verify(this.filterChain).doFilter(this.httpServletRequest, this.httpServletResponse);
    }


}