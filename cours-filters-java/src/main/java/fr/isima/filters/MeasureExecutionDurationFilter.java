package fr.isima.filters;

import static java.time.LocalTime.now;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Ce filter mesure le temps d'execution d'un fr.isima.service, en utilisant la nouvelle
 * API de date de Java inspirée de la librarie joda time.
 * 
 * @author Benjamin
 *
 */
@WebFilter("/*")
public class MeasureExecutionDurationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // utilisation de l'import static import static java.time.LocalTime.now;
        final LocalTime before = now();
        chain.doFilter(req, resp);
        final LocalTime after = now();
        final Duration duration = Duration.between(before, after);
        final HttpServletRequest httpReq = (HttpServletRequest) req;
        System.out.println("Execution of " + httpReq.getServletPath() + " took " + duration.toMillis() + "ms");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
