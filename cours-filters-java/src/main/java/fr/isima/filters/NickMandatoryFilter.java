package fr.isima.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Permet de vérifer qu'un parametre est bien passé systématiquement.
 * <p>
 * Habituellement, les informations d'authentification sont plutôt transmises
 * dans le header HTTP (Cookies ou jeton).
 * </p>
 * 
 * @author Benjamin
 *
 */
@WebFilter("/welcome/*")
public class NickMandatoryFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        final HttpServletResponse httpResp = (HttpServletResponse) resp;
        final String nick = req.getParameter("nick");
        if (nick == null) {
            httpResp.sendError(401, "Je ne dis pas bonjour aux inconnus");
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
