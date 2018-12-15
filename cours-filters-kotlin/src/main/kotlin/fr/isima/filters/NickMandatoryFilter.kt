package fr.isima.filters

import java.io.IOException
import javax.servlet.*
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletResponse

/**
 * Permet de vérifer qu'un parametre est bien passé systématiquement.
 *
 *
 * Habituellement, les informations d'authentification sont plutôt transmises
 * dans le header HTTP (Cookies ou jeton).
 *
 *
 * @author Benjamin
 */
@WebFilter("/welcome/*")
class NickMandatoryFilter : Filter {

    override fun doFilter(req: ServletRequest, resp: ServletResponse, chain: FilterChain) {
        val httpResp = resp as HttpServletResponse
        when (req.getParameter("nick")) {
            null -> httpResp.sendError(401, "Je ne dis pas bonjour aux inconnus")
            else -> chain.doFilter(req, resp)
        }
    }

    override fun destroy() {}

    @Throws(ServletException::class)
    override fun init(arg0: FilterConfig) {
    }

}
