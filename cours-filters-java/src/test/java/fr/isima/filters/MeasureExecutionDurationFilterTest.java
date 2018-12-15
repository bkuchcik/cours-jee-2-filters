package fr.isima.filters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MeasureExecutionDurationFilterTest {

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

    @Mock
    private FilterChain filterChain;

    private MeasureExecutionDurationFilter measureExecutionDurationFilter = new MeasureExecutionDurationFilter();

    //le test n'a pas d'output facile à vérifier, mais on peut
    //tout de même valider que la filter chain n'est pas interrompu
    // ps system.out ne doit pas figurer dans des codes de production
    // il faut utiliser des loggers
    @Test
    public void doFilter_AlwaysContinueFilterChain() throws IOException, ServletException {
        this.measureExecutionDurationFilter
                .doFilter(this.httpServletRequest, this.httpServletResponse, this.filterChain);
        verify(this.filterChain).doFilter(this.httpServletRequest, this.httpServletResponse);
    }
}