package fr.isima.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Filtre permettant de compter le nombre de requêtes.
 * <p>
 * A noter que l'utilisation de {@link System#out} est généralement interdite
 * dans les projets en production, et que les informations de ce type sont
 * écrites par exemple dans des fichiers de logs.
 * </p>
 *
 * @author Benjamin
 */
@WebFilter("/*")
public class CounterFilter implements Filter {

    private AtomicLong counter = new AtomicLong();

    @Override
    public void doFilter(ServletRequest req, ServletResponse rep,
                         FilterChain chain) throws IOException, ServletException {

        System.out.println("Nombre de requetes " + counter.incrementAndGet());
        chain.doFilter(req, rep);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }


    long getCounter() {
        return counter.get();
    }
}
